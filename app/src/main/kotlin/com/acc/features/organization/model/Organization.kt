package com.acc.features.organization.model

data class Organization(
    val id: String = "",
    val organizationId: String = "",
    val name: String = "",
    val postCode: String = "",
    val address: String = "",
    val selected: Boolean = false,
    val createdOn: Long = 0
)