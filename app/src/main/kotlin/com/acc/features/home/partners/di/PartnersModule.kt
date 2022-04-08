package com.acc.features.home.partners.di

import com.acc.features.home.partners.add.presentation.viewmodel.AddPartnerViewModel
import org.koin.dsl.module

val partnersViewModel = module {
    factory { AddPartnerViewModel() }
}