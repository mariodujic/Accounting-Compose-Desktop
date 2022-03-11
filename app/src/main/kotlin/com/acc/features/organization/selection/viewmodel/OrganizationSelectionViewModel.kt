package com.acc.features.organization.selection.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.model.Organization
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class Company(
    val name: String,
    val selected: Boolean
)

class OrganizationSelectionViewModel(
    private val organizationRepository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val organizations = organizationRepository.getOrganizations()
        .stateIn(
            ioCoroutineScope,
            SharingStarted.Lazily,
            emptyList()
        )

    val selectedCompany = organizations.map {
        it.firstOrNull { organization -> organization.selected }
    }.stateIn(
        ioCoroutineScope,
        SharingStarted.Lazily,
        null
    )

    fun selectCompany(organization: Organization) {
        ioCoroutineScope.launch {
            organizationRepository.selectOrganization(organizationId = organization.organizationId)
        }
    }
}