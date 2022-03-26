package com.acc.features.home.chartofaccounts.add.presentation.viewmodel

import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class AddChartOfAccountsViewModel : Entry {

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

    val accountValid = combine(_accountNumber, _accountDescription) { number, description ->
        number.isNotEmpty() && description.isNotEmpty()
    }
}