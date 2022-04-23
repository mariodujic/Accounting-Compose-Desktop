package com.acc.features.home.partners.list.presentation.viewmodel

import com.acc.features.home.partners.data.repository.PartnersRepository
import com.acc.features.home.partners.model.Partner
import com.acc.features.organization.data.repository.OrganizationRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PartnersViewModel(
    private val partnersRepository: PartnersRepository,
    private val organizationRepository: OrganizationRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val partners = partnersRepository.getPartners().map {
        val organization = organizationRepository.getSelectedOrganization().first()
        val organizationId = organization?.organizationId
        it.filter { account -> account.organizationId == organizationId }
    }

    private val _selectedPartner = MutableStateFlow<Partner?>(null)
    val selectedPartner = _selectedPartner

    fun selectPartner(partner: Partner) {
        _selectedPartner.tryEmit(partner)

    }

    fun deletePartner(id: String) {
        ioCoroutineScope.launch {
            partnersRepository.deletePartner(id)
        }
    }
}