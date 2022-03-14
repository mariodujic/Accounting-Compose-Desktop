package com.preferences

import org.koin.dsl.module

val preferencesModule = module {
    single { Preferences() }
}