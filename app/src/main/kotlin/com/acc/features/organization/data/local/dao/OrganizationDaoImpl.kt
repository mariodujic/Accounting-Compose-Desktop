package com.acc.features.organization.data.local.dao

import com.acc.features.organization.model.Organization
import com.acc.utils.UuidUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import java.sql.Connection

class OrganizationDaoImpl(
    private val connection: Connection,
    private val uuidUtils: UuidUtils
) : OrganizationDao {

    private val table = "organization"
    private val statement = connection.createStatement()

    init {
        createTableIfMissing()
    }

    private fun createTableIfMissing() {
        val createTableStatement: String =
            """
            CREATE TABLE IF NOT EXISTS $table (
            id text PRIMARY KEY,
            organizationId text NOT NULL,
            name text NOT NULL,
            postCode text NOT NULL,
            address text NOT NULL,
            selected integer NOT NULL
            )
            """
        statement.execute(createTableStatement)
    }

    private val updateOrganizations: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>(1).also {
        it.tryEmit(Unit)
    }

    override suspend fun insertOrganization(organization: Organization) {
        val insertOrganizationStatement = "INSERT INTO $table values(?,?,?,?,?,?)"
        val prepareStatement = connection.prepareStatement(insertOrganizationStatement)
        prepareStatement.setString(1, uuidUtils.getUuid())
        prepareStatement.setString(2, organization.organizationId)
        prepareStatement.setString(3, organization.name)
        prepareStatement.setString(4, organization.postCode)
        prepareStatement.setString(5, organization.address)
        prepareStatement.setBoolean(6, organization.selected)
        prepareStatement.executeUpdate()
        updateOrganizations.emit(Unit)
    }

    override fun getOrganizations(): Flow<List<Organization>> {
        return updateOrganizations.map {
            val query = "SELECT * FROM $table"
            val resultSet = statement.executeQuery(query)
            val organizationList = buildList {
                while (resultSet.next()) {
                    add(
                        with(resultSet) {
                            Organization(
                                id = getString("id"),
                                organizationId = getString("organizationId"),
                                name = getString("name"),
                                postCode = getString("postCode"),
                                address = getString("address"),
                                selected = getBoolean("selected")
                            )
                        }
                    )
                }
            }
            organizationList
        }
    }

    override suspend fun selectOrganization(organizationId: String) {
        val unselectOrganizationQuery = "UPDATE $table SET selected = 0"
        statement.execute(unselectOrganizationQuery)
        val selectOrganizationQuery = "UPDATE $table SET selected = 1 WHERE organizationId = ?"
        val preparedStatement = connection.prepareStatement(selectOrganizationQuery)
        preparedStatement.setString(1, organizationId)
        preparedStatement.executeUpdate()
        updateOrganizations.emit(Unit)
    }
}