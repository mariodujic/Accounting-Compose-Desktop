package com.acc.features.organization.create.presentation.viewmodel

import com.acc.features.organization.create.presentation.result.CreateOrganizationResult
import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.model.Organization
import com.navigation.Entry
import com.utils.DateUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CreateOrganizationViewModel(
    private val repository: OrganizationRepository,
    private val dateUtils: DateUtils,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    private val _result: MutableStateFlow<CreateOrganizationResult> = MutableStateFlow(CreateOrganizationResult.IDLE)
    val result: StateFlow<CreateOrganizationResult> = _result

    fun createOrganization(organizationId: String, name: String, postCode: String, address: String) {

        ioCoroutineScope.launch {
            if (organizationDataValid(organizationId)) {
                _result.emit(CreateOrganizationResult.ERROR)
                return@launch
            }

            val organization = Organization(
                organizationId = organizationId,
                name = name,
                postCode = postCode,
                address = address,
                createdOn = dateUtils.getCurrentTime()
            )
            repository.insertOrganization(organization)
            _result.emit(CreateOrganizationResult.SUCCESS)
        }
    }

    private suspend fun organizationDataValid(organizationId: String): Boolean {
        return repository.getOrganizations().first().any { it.organizationId == organizationId }
    }
}