package com.acc.features.organization.create.data.repository

import com.acc.features.organization.create.data.local.dao.CreateOrganizationDao
import com.acc.features.organization.model.Organization

class CreateOrganizationRepository(private val dao: CreateOrganizationDao) {

    suspend fun insertOrganization(organization: Organization) {
        dao.insertOrganization(organization)
    }

    suspend fun getOrganizations(): List<Organization> {
        return dao.getOrganizations()
    }

    suspend fun organizationExists(organizationId: String): Boolean {
        return dao.getOrganizations().any { it.organizationId == organizationId }
    }
}