package com.acc.features.organization.fakes

import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class OrganizationRepositoryFake : OrganizationRepository {

    private val organizations = MutableStateFlow<List<Organization>>(listOf())

    override suspend fun insertOrganization(organization: Organization) {
        organizations.tryEmit(listOf(organization))
    }

    override fun getOrganizations(): Flow<List<Organization>> {
        return organizations
    }

    override fun getSelectedOrganization(): Flow<Organization?> {
        return organizations.map { organizations -> organizations.firstOrNull { it.selected } }
    }

    override suspend fun selectOrganization(organizationId: String) {
        val organizationList = organizations.value.map {
            if (it.organizationId == organizationId) it.copy(selected = true)
            else it
        }
        organizations.tryEmit(organizationList)
    }

    override suspend fun unselectOrganizations() {
        val organizationList = organizations.value.map {
            if (it.selected) it.copy(selected = false)
            else it
        }
        organizations.tryEmit(organizationList)
    }
}