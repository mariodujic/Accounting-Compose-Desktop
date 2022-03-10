package com.acc.features.organization.create.data.local.dao

import com.acc.features.organization.model.Organization

interface CreateOrganizationDao {

    suspend fun insertOrganization(organization: Organization)
    suspend fun getOrganizations(): List<Organization>
}