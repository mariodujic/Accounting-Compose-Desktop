package com.acc.features.home.expenses.di

import com.acc.features.home.expenses.add.presentation.viewmodel.AddExpenseViewModel
import org.koin.dsl.module

val expensesModule = module {
    factory { AddExpenseViewModel(get()) }
}