package com.acc.features.organization.data.local.dao

import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow

interface OrganizationDao {

    suspend fun insertOrganization(organization: Organization)
    fun getOrganizations(): Flow<List<Organization>>
    suspend fun selectOrganization(organizationId: String)
}