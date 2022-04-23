package com.acc.features.home.chartofaccounts.model

import com.acc.features.home.partners.model.Partner

data class ChartAccount(
    val id: String,
    val number: String,
    val description: String,
    val partner: Partner? = null,
    val organizationId: String,
    val createdOn: Long
)