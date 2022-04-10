package com.acc.features.home.partners.di

import com.acc.features.home.partners.add.presentation.viewmodel.AddPartnerViewModel
import com.acc.features.home.partners.data.local.dao.PartnersDao
import com.acc.features.home.partners.data.local.dao.PartnersDaoImpl
import com.acc.features.home.partners.data.repository.PartnersRepository
import com.acc.features.home.partners.list.presentation.viewmodel.PartnersViewModel
import org.koin.dsl.module

val partnersViewModel = module {
    factory { AddPartnerViewModel(get(), get()) }
    factory { PartnersViewModel(get(), get()) }
    factory { PartnersRepository(get()) }
    single<PartnersDao> { PartnersDaoImpl(get(), get()) }
}