package com.acc.features.organization.create.data.local.dao

import com.acc.features.organization.model.Organization
import com.acc.utils.UuidUtils
import java.sql.Connection

class CreateOrganizationDaoImpl(
    private val connection: Connection,
    private val uuidUtils: UuidUtils
) : CreateOrganizationDao {

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
            address text NOT NULL
            )
            """
        statement.execute(createTableStatement)
    }

    override suspend fun insertOrganization(organization: Organization) {
        val insertOrganizationStatement = "INSERT INTO $table values(?,?,?,?,?)"
        val prepareStatement = connection.prepareStatement(insertOrganizationStatement)
        prepareStatement.setString(1, uuidUtils.getUuid())
        prepareStatement.setString(2, organization.organizationId)
        prepareStatement.setString(3, organization.name)
        prepareStatement.setString(4, organization.postCode)
        prepareStatement.setString(5, organization.address)
        prepareStatement.executeUpdate()
    }

    override suspend fun getOrganizations(): List<Organization> {
        val query = "SELECT * FROM $table"
        val resultSet = statement.executeQuery(query)
        val organizations = buildList {
            while (resultSet.next()) {
                add(
                    with(resultSet) {
                        Organization(
                            id = getString("id"),
                            organizationId = getString("organizationId"),
                            name = getString("name"),
                            postCode = getString("postCode"),
                            address = getString("address")
                        )
                    }
                )
            }
        }
        return organizations
    }
}