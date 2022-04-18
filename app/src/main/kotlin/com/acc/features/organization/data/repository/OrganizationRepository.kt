package com.acc.features.organization.data.repository

import com.acc.features.organization.model.Organization
import kotlinx.coroutines.flow.Flow

interface OrganizationRepository {

    suspend fun insertOrganization(organization: Organization)
    fun getOrganizations(): Flow<List<Organization>>
    fun getSelectedOrganization(): Flow<Organization?>
    suspend fun selectOrganization(organizationId: String)
    suspend fun unselectOrganizations()
}