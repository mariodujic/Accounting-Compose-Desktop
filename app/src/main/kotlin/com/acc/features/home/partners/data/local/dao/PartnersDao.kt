package com.acc.features.home.partners.data.local.dao

import com.acc.features.home.partners.model.Partner
import kotlinx.coroutines.flow.Flow

interface PartnersDao {

    suspend fun insertPartner(name: String, address: String, phoneNumber: String)
    fun getPartners(): Flow<List<Partner>>
}