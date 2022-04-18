package com.acc.features.organization.data.repository

import com.acc.features.organization.data.local.dao.OrganizationDao
import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OrganizationRepositoryImpl(private val dao: OrganizationDao): OrganizationRepository {

    override suspend fun insertOrganization(organization: Organization) {
        dao.insertOrganization(organization)
    }

    override fun getOrganizations(): Flow<List<Organization>> {
        return dao.getOrganizations()
    }

    override fun getSelectedOrganization(): Flow<Organization?> {
        return dao.getOrganizations().map {
            it.firstOrNull { organization -> organization.selected }
        }
    }

    override suspend fun selectOrganization(organizationId: String) {
        dao.selectOrganization(organizationId)
    }

    override suspend fun unselectOrganizations() {
        dao.unselectOrganizations()
    }
}