package com.acc.features.organization.data.repository

import com.acc.features.organization.data.local.dao.OrganizationDao
import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow

class OrganizationRepository(private val dao: OrganizationDao) {

    suspend fun insertOrganization(organization: Organization) {
        dao.insertOrganization(organization)
    }

    fun getOrganizations(): Flow<List<Organization>> {
        return dao.getOrganizations()
    }

    suspend fun selectOrganization(organizationId: String) {
        dao.selectOrganization(organizationId)
    }
}