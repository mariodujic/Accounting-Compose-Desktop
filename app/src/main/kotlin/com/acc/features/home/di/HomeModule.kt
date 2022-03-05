package com.acc.features.home.di

import com.acc.features.home.viewmodel.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    factory { HomeViewModel() }
}