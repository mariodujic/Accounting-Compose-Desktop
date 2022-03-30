package com.acc.features.settings.presentation.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    fun unselectOrganizations() {
        ioCoroutineScope.launch {
            repository.unselectOrganizations()
        }
    }
}