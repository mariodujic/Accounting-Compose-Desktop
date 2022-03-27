package com.acc.features.home.chartofaccounts.di

import com.acc.features.home.chartofaccounts.add.presentation.viewmodel.AddChartOfAccountsViewModel
import com.acc.features.home.chartofaccounts.data.local.dao.ChartOfAccountsDao
import com.acc.features.home.chartofaccounts.data.local.dao.ChartOfAccountsDaoImpl
import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import org.koin.dsl.module

val chartOfAccountsModule = module {
    factory { AddChartOfAccountsViewModel(get(), get()) }
    factory { ChartOfAccountsRepository(get()) }
    single<ChartOfAccountsDao> { ChartOfAccountsDaoImpl(get(), get()) }
}