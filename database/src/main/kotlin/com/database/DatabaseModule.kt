package com.database

import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseConnection().connection }
}