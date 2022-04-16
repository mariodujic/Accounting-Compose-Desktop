package com.acc.common.locale.di

import com.acc.common.locale.presentation.viewmodel.LocaleViewModel
import org.koin.dsl.module

val localeModule = module {
    factory { LocaleViewModel(get()) }
}