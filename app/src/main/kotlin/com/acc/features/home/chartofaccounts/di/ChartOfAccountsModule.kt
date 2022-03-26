package com.acc.features.home.chartofaccounts.di

import com.acc.features.home.chartofaccounts.add.presentation.viewmodel.AddChartOfAccountsViewModel
import org.koin.dsl.module

val chartOfAccountsModule = module {
    factory { AddChartOfAccountsViewModel() }
}