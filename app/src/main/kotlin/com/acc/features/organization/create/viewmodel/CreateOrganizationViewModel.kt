package com.acc.features.organization.create.viewmodel

import com.acc.features.organization.model.Organization
import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateOrganizationViewModel : Entry {

    private val _organization: MutableStateFlow<Organization> = MutableStateFlow(Organization())
    val organization: StateFlow<Organization> = _organization

    fun createOrganization(id: String, name: String, postalCode: String, address: String) {

    }
}