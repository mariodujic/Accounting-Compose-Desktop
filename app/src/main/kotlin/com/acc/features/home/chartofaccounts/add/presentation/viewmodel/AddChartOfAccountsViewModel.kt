package com.acc.features.home.chartofaccounts.add.presentation.viewmodel

import com.acc.features.home.chartofaccounts.add.presentation.result.AddChartAccountResult
import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.acc.features.home.partners.data.repository.PartnersRepository
import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AddChartOfAccountsViewModel(
    private val accountsRepository: ChartOfAccountsRepository,
    private val partnersRepository: PartnersRepository,
    private val organizationRepository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    private val _accountNumber = MutableStateFlow("")
    val accountNumber: StateFlow<String> = _accountNumber

    fun setAccountNumber(accountNumber: String) {
        _accountNumber.tryEmit(accountNumber)
    }

    private val _accountDescription = MutableStateFlow("")
    val accountDescription: StateFlow<String> = _accountDescription

    fun setAccountDescription(accountDescription: String) {
        _accountDescription.tryEmit(accountDescription)
    }

    private val _partnerId = MutableStateFlow("")
    val partnerName: Flow<String?> = _partnerId.map { partnerId ->
        val partner = partnersRepository.getPartnerById(partnerId)
        val partnerName = partner?.name
        partnerName
    }

    fun setPartner(partnerId: String) {
        _partnerId.tryEmit(partnerId)
    }

    val accountValid = combine(_accountNumber, _accountDescription) { number, description ->
        number.isNotEmpty() && description.isNotEmpty()
    }

    private val _addChartResult = MutableStateFlow(AddChartAccountResult.LOADING)
    val addChartResult: StateFlow<AddChartAccountResult> = _addChartResult

    fun addChartAccount() {
        ioCoroutineScope.launch {
            _addChartResult.emit(AddChartAccountResult.LOADING)
            val accounts = accountsRepository.getChartOfAccounts().first()
            val accountNumberTaken = accounts.any { it.number == _accountNumber.value }
            if (accountNumberTaken) {
                _addChartResult.emit(AddChartAccountResult.ERROR_ACCOUNT_NUMBER_EXISTS)
            } else {
                val accountNumber = _accountNumber.value.trim()
                val accountDescription = _accountDescription.value.trim()
                val partnerId = _partnerId.value
                val organization = organizationRepository.getSelectedOrganization().first()
                val organizationId = organization?.organizationId ?: return@launch
                accountsRepository.insertAccount(accountNumber, accountDescription, partnerId, organizationId)
                setAccountNumber("")
                setAccountDescription("")
                setPartner("")
            }
        }
    }

    val partners = partnersRepository.getPartners()
}