package com.acc.features.home.chartofaccounts.add.presentation.viewmodel

import com.acc.features.home.chartofaccounts.add.presentation.result.AddChartAccountResult
import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AddChartOfAccountsViewModel(
    private val repository: ChartOfAccountsRepository,
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

    val accountValid = combine(_accountNumber, _accountDescription) { number, description ->
        number.isNotEmpty() && description.isNotEmpty()
    }

    private val _addChartResult = MutableStateFlow(AddChartAccountResult.LOADING)
    val addChartResult: StateFlow<AddChartAccountResult> = _addChartResult

    fun addChartAccount() {
        ioCoroutineScope.launch {
            _addChartResult.emit(AddChartAccountResult.LOADING)
            val accounts = repository.getChartOfAccounts().first()
            val accountNumberTaken = accounts.any { it.number == _accountNumber.value }
            if (accountNumberTaken) {
                _addChartResult.emit(AddChartAccountResult.ERROR_ACCOUNT_NUMBER_EXISTS)
            } else {
                val accountNumber = _accountNumber.value.trim()
                val accountDescription = _accountDescription.value.trim()
                repository.insertAccount(accountNumber, accountDescription)
                setAccountNumber("")
                setAccountDescription("")
            }
        }
    }
}