package com.acc.features.home.chartofaccounts.list.presentation.viewmodel

import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.navigation.Entry

class ChartOfAccountsViewModel(private val repository: ChartOfAccountsRepository) : Entry {

    val getAccounts = repository.getChartOfAccounts()
}