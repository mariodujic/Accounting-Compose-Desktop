package com.acc.features.organization.selection.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.model.Organization
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OrganizationSelectionViewModel(
    private val organizationRepository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val organizations = organizationRepository.getOrganizations()

    val selectedOrganization = organizations.map {
        it.firstOrNull { organization -> organization.selected }
    }

    val hasSelectedOrganization = selectedOrganization.map {
        it != null
    }

    fun selectOrganization(organization: Organization) {
        ioCoroutineScope.launch {
            organizationRepository.selectOrganization(organizationId = organization.organizationId)
        }
    }
}