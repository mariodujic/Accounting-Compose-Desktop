package com.acc.features.home.presentation.di

import com.acc.features.home.presentation.viewmodel.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    factory { HomeViewModel() }
}