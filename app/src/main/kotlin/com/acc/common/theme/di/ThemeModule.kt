package com.acc.common.theme.di

import com.acc.common.theme.viewmodel.ThemeViewModel
import org.koin.dsl.module

val themeModule = module {
    factory { ThemeViewModel(get(), get()) }
}