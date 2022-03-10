package com.acc.common.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coroutinesModule = module {
    single { CoroutineScope(Dispatchers.IO) }
}