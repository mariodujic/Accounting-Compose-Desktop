package com.acc.features.home.presentation.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    organizationRepository: OrganizationRepository,
    ioCoroutineScope: CoroutineScope
) : Entry {

    val selectedOrganizationName = organizationRepository.getOrganizations().map {
        it.firstOrNull { organization -> organization.selected }?.name.orEmpty()
    }.stateIn(
        ioCoroutineScope,
        SharingStarted.WhileSubscribed(1000),
        ""
    )
}