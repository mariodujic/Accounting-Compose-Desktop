package com.acc.features.home.chartofaccounts.data.local.dao

import com.acc.features.home.chartofaccounts.model.ChartAccount
import com.acc.features.home.partners.data.local.dao.PartnersDao
import com.utils.DateUtils
import com.utils.UuidUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import java.sql.Connection

class ChartOfAccountsDaoImpl(
    private val connection: Connection,
    private val partnerDao: PartnersDao,
    private val uuidUtils: UuidUtils,
    private val dateUtils: DateUtils
) : ChartOfAccountsDao {

    private val table = "chart_account"

    init {
        createTableIfMissing()
    }

    private fun createTableIfMissing() {
        val createTableStatement =
            """
            CREATE TABLE IF NOT EXISTS $table (
            id text PRIMARY KEY,
            number text NOT NULL,
            description text NOT NULL,
            partner_id text NOT NULL,
            organization_id text NOT NULL,
            created_on number NOT NULL
            )
            """
        val statement = connection.createStatement()
        statement.execute(createTableStatement)
        statement.close()
    }

    private val updateAccounts: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>(1).also {
        it.tryEmit(Unit)
    }

    override suspend fun insertAccount(number: String, description: String, partnerId: String, organizationId: String) {
        val insertAccountStatement = "INSERT INTO $table values(?,?,?,?,?,?)"
        val prepareStatement = connection.prepareStatement(insertAccountStatement)
        prepareStatement.setString(1, uuidUtils.getUuid())
        prepareStatement.setString(2, number)
        prepareStatement.setString(3, description)
        prepareStatement.setString(4, partnerId)
        prepareStatement.setString(5, organizationId)
        prepareStatement.setLong(6, dateUtils.getCurrentTime())
        prepareStatement.executeUpdate()
        prepareStatement.close()
        updateAccounts.emit(Unit)
    }

    override suspend fun deleteAccount(id: String) {
        val deleteAccountStatement = "DELETE FROM $table WHERE id=?"
        val prepareStatement = connection.prepareStatement(deleteAccountStatement)
        prepareStatement.setString(1, id)
        prepareStatement.executeUpdate()
        prepareStatement.close()
        updateAccounts.emit(Unit)
    }

    override fun getChartOfAccounts(): Flow<List<ChartAccount>> {
        return updateAccounts.map {
            val query = "SELECT * FROM $table"
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(query)
            val chartOfAccounts = buildList {
                while (resultSet.next()) {
                    add(
                        with(resultSet) {
                            val partnerId = getString("partner_id")
                            val partner = partnerDao.getPartnerById(partnerId)
                            ChartAccount(
                                id = getString("id"),
                                number = getString("number"),
                                description = getString("description"),
                                partner = partner,
                                organizationId = getString("organization_id"),
                                createdOn = getLong("created_on")
                            )
                        }
                    )
                }
                resultSet.close()
                statement.close()
            }
            chartOfAccounts
        }
    }
}