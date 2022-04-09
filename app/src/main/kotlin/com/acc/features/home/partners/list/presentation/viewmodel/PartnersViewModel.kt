package com.acc.features.home.partners.list.presentation.viewmodel

import com.acc.features.home.partners.data.repository.PartnersRepository
import com.acc.features.home.partners.model.Partner
import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow

class PartnersViewModel(private val repository: PartnersRepository) : Entry {

    val partners = repository.getPartners()

    private val _selectedPartner = MutableStateFlow<Partner?>(null)
    val selectedPartner = _selectedPartner

    fun selectPartner(partner: Partner) {
        _selectedPartner.tryEmit(partner)

    }
}