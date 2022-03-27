package com.acc.features.home.chartofaccounts.data.repository

import com.acc.features.home.chartofaccounts.data.local.dao.ChartOfAccountsDao
import com.acc.features.home.chartofaccounts.model.ChartAccount
import kotlinx.coroutines.flow.Flow

class ChartOfAccountsRepository(private val dao: ChartOfAccountsDao) {

    suspend fun insertAccount(number: String, description: String) {
        dao.insertAccount(number, description)
    }

    fun getChartOfAccounts(): Flow<List<ChartAccount>> {
        return dao.getChartOfAccounts()
    }
}