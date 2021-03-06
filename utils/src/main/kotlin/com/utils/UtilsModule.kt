package com.utils

import org.koin.dsl.module

val utilsModule = module {
    single { UuidUtils() }
    single<DateUtils> { DateUtilsImpl() }
}