package com.acc.features.home.chartofaccounts.list.presentation.viewmodel

import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.acc.features.home.chartofaccounts.model.ChartAccount
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ChartOfAccountsViewModel(
    private val repository: ChartOfAccountsRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val accounts = repository.getChartOfAccounts()

    private val _selectedAccount = MutableStateFlow<ChartAccount?>(null)
    val selectedAccount = _selectedAccount

    fun selectAccount(account: ChartAccount) {
        _selectedAccount.tryEmit(account)
    }

    fun deleteAccount(id: String) {
        ioCoroutineScope.launch {
            repository.deleteAccount(id)
        }
    }
}