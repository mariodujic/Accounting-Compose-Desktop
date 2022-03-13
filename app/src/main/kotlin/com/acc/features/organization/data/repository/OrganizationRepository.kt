package com.acc.features.organization.data.repository

import com.acc.features.organization.data.local.dao.OrganizationDao
import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OrganizationRepository(private val dao: OrganizationDao) {

    suspend fun insertOrganization(organization: Organization) {
        dao.insertOrganization(organization)
    }

    fun getOrganizations(): Flow<List<Organization>> {
        return dao.getOrganizations()
    }

    fun getSelectedOrganization(): Flow<Organization?> {
        return dao.getOrganizations().map {
            it.firstOrNull { organization -> organization.selected }
        }
    }

    suspend fun selectOrganization(organizationId: String) {
        dao.selectOrganization(organizationId)
    }
}