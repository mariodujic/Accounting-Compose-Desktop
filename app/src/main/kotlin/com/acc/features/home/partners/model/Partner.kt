package com.acc.features.home.partners.model

data class Partner(
    val id: String = "",
    val name: String,
    val address: String,
    val phoneNumber: String,
    val createdOn: Long
)
