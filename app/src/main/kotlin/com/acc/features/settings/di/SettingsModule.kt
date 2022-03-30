package com.acc.features.settings.di

import com.acc.features.settings.presentation.viewmodel.SettingsViewModel
import org.koin.dsl.module

val settingsModule = module {
    factory { SettingsViewModel(get(), get()) }
}