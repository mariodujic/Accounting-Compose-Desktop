package com.acc.features.home.chartofaccounts.di

import com.acc.features.home.chartofaccounts.add.presentation.viewmodel.AddChartOfAccountsViewModel
import com.acc.features.home.chartofaccounts.data.local.dao.ChartOfAccountsDao
import com.acc.features.home.chartofaccounts.data.local.dao.ChartOfAccountsDaoImpl
import com.acc.features.home.chartofaccounts.data.repository.ChartOfAccountsRepository
import com.acc.features.home.chartofaccounts.list.presentation.viewmodel.ChartOfAccountsViewModel
import org.koin.dsl.module

val chartOfAccountsModule = module {
    factory { AddChartOfAccountsViewModel(get(), get(), get()) }
    factory { ChartOfAccountsViewModel(get(), get()) }
    factory { ChartOfAccountsRepository(get()) }
    single<ChartOfAccountsDao> { ChartOfAccountsDaoImpl(get(), get(), get()) }
}