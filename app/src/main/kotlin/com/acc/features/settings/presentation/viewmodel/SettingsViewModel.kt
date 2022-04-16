package com.acc.features.settings.presentation.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import com.preferences.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: OrganizationRepository,
    private val preferences: Preferences,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    fun unselectOrganizations() {
        ioCoroutineScope.launch {
            repository.unselectOrganizations()
        }
    }

    val vatRate = preferences.get(VAT_RATE_KEY, 0)
    private val _vatUpdateError = MutableStateFlow(false)
    val vatUpdateError: StateFlow<Boolean> = _vatUpdateError

    fun storeVatRate(rate: String) {
        _vatUpdateError.tryEmit(false)
        val vatRate = rate.toIntOrNull()
        if (vatRate == null) {
            _vatUpdateError.tryEmit(true)
        }
        preferences.set(VAT_RATE_KEY, vatRate)
    }

    private companion object {
        const val VAT_RATE_KEY = "vatRateKey"
    }
}