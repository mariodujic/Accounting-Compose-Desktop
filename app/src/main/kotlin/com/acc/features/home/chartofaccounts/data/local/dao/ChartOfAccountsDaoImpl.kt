package com.acc.features.home.chartofaccounts.data.local.dao

import com.acc.features.home.chartofaccounts.model.ChartAccount
import com.utils.UuidUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import java.sql.Connection

class ChartOfAccountsDaoImpl(
    private val connection: Connection,
    private val uuidUtils: UuidUtils
) : ChartOfAccountsDao {

    private val table = "chart_account"
    private val statement = connection.createStatement()

    init {
        createTableIfMissing()
    }

    private fun createTableIfMissing() {
        val createTableStatement: String =
            """
            CREATE TABLE IF NOT EXISTS $table (
            id text PRIMARY KEY,
            number text NOT NULL,
            description text NOT NULL
            )
            """
        statement.execute(createTableStatement)
    }

    private val updateAccounts: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>(1).also {
        it.tryEmit(Unit)
    }

    override suspend fun insertAccount(number: String, description: String) {
        val insertAccountStatement = "INSERT INTO $table values(?,?,?)"
        val prepareStatement = connection.prepareStatement(insertAccountStatement)
        prepareStatement.setString(1, uuidUtils.getUuid())
        prepareStatement.setString(2, number)
        prepareStatement.setString(3, description)
        prepareStatement.executeUpdate()
        updateAccounts.emit(Unit)
    }

    override fun getChartOfAccounts(): Flow<List<ChartAccount>> {
        return updateAccounts.map {
            val query = "SELECT * FROM $table"
            val resultSet = statement.executeQuery(query)
            val chartOfAccounts = buildList {
                while (resultSet.next()) {
                    add(
                        with(resultSet) {
                            ChartAccount(
                                id = getString("id"),
                                number = getString("number"),
                                description = getString("description")
                            )
                        }
                    )
                }
            }
            chartOfAccounts
        }
    }
}