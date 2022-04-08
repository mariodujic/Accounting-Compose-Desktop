package com.acc.features.home.partners.add.presentation.viewmodel

import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddPartnerViewModel : Entry {

    private val _partnerName = MutableStateFlow("")
    val partnerName: StateFlow<String> = _partnerName

    fun setPartnerName(partnerName: String) {
        _partnerName.tryEmit(partnerName)
    }

    private val _partnerAddress = MutableStateFlow("")
    val partnerAddress: StateFlow<String> = _partnerAddress

    fun setPartnerAddress(partnerAddress: String) {
        _partnerAddress.tryEmit(partnerAddress)
    }

    private val _partnerPhoneNumber = MutableStateFlow("")
    val partnerPhoneNumber: StateFlow<String> = _partnerPhoneNumber

    fun setPartnerPhoneNumber(partnerPhoneNumber: String) {
        _partnerPhoneNumber.tryEmit(partnerPhoneNumber)
    }

    fun addPartner() {

    }
}