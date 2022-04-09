package com.acc.features.home.partners.add.presentation.viewmodel

import com.acc.features.home.partners.data.repository.PartnersRepository
import com.navigation.Entry
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddPartnerViewModel(
    private val repository: PartnersRepository,
    private val ioCoroutineScope: CoroutineScope
) : Entry {

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
        ioCoroutineScope.launch {
            val name = _partnerName.value.trim()
            val address = _partnerAddress.value.trim()
            val phoneNumber = _partnerPhoneNumber.value.trim()
            repository.insertPartner(
                name = name,
                address = address,
                phoneNumber = phoneNumber
            )
            setPartnerName("")
            setPartnerAddress("")
            setPartnerPhoneNumber("")
        }
    }
}