package com.acc.features.organization.create.presentation.viewmodel

import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.model.Organization
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CreateOrganizationViewModel(
    private val repository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    fun createOrganization(organizationId: String, name: String, postCode: String, address: String) {
        ioCoroutineScope.launch {
            val organization = Organization(
                organizationId = organizationId,
                name = name,
                postCode = postCode,
                address = address
            )
            repository.insertOrganization(organization)
        }
    }
}