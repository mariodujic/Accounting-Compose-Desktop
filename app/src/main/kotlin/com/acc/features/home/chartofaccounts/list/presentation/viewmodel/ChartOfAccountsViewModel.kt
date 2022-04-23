package com.acc.features.home.chartofaccounts.list.presentation.viewmodel

import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.acc.features.home.chartofaccounts.model.ChartAccount
import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ChartOfAccountsViewModel(
    private val chartOfAccountsRepository: ChartOfAccountsRepository,
    private val organizationRepository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val accounts = chartOfAccountsRepository.getChartOfAccounts().map {
        val organization = organizationRepository.getSelectedOrganization().first()
        val organizationId = organization?.organizationId
        it.filter { account -> account.organizationId == organizationId }
    }

    private val _selectedAccount = MutableStateFlow<ChartAccount?>(null)
    val selectedAccount = _selectedAccount

    fun selectAccount(account: ChartAccount) {
        _selectedAccount.tryEmit(account)
    }

    fun deleteAccount(id: String) {
        ioCoroutineScope.launch {
            chartOfAccountsRepository.deleteAccount(id)
        }
    }
}