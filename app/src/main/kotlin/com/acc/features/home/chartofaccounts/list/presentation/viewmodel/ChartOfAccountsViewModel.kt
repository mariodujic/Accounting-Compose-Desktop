package com.acc.features.home.chartofaccounts.list.presentation.viewmodel

import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.acc.features.home.chartofaccounts.model.ChartAccount
import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow

class ChartOfAccountsViewModel(private val repository: ChartOfAccountsRepository) : Entry {

    val accounts = repository.getChartOfAccounts()

    private val _selectedAccount = MutableStateFlow<ChartAccount?>(null)
    val selectedAccount = _selectedAccount

    fun selectAccount(account: ChartAccount) {
        _selectedAccount.tryEmit(account)
    }
}