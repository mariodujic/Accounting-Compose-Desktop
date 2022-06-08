package com.acc.features.home.expenses.add.presentation.viewmodel

import com.acc.features.home.partners.data.repository.PartnersRepository
import com.navigation.Entry
import kotlinx.coroutines.flow.*

class AddExpenseViewModel(
    private val partnersRepository: PartnersRepository
) : Entry {

    private val _accountNumber = MutableStateFlow("")
    val accountNumber: StateFlow<String> = _accountNumber

    fun setAccountNumber(accountNumber: String) {
        _accountNumber.tryEmit(accountNumber)
    }

    private val _expenseDescription = MutableStateFlow("")
    val expenseDescription: StateFlow<String> = _expenseDescription

    fun setExpenseDescription(expenseDescription: String) {
        _expenseDescription.tryEmit(expenseDescription)
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

    val partners = partnersRepository.getPartners()

    val expenseValid = combine(_accountNumber, _partnerId) { accountNumber, partnerId ->
        accountNumber.isNotEmpty() && partnerId.isNotEmpty()
    }

    fun addExpense() {

    }
}