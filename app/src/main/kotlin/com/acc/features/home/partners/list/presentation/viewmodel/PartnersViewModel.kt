package com.acc.features.home.partners.list.presentation.viewmodel

import com.acc.features.home.partners.data.repository.PartnersRepository
import com.acc.features.home.partners.model.Partner
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PartnersViewModel(
    private val repository: PartnersRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

    val partners = repository.getPartners()

    private val _selectedPartner = MutableStateFlow<Partner?>(null)
    val selectedPartner = _selectedPartner

    fun selectPartner(partner: Partner) {
        _selectedPartner.tryEmit(partner)

    }

    fun deletePartner(id: String) {
        ioCoroutineScope.launch {
            repository.deletePartner(id)
        }
    }
}