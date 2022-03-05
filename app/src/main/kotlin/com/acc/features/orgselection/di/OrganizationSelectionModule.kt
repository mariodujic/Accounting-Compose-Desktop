package com.acc.features.orgselection.di

import com.acc.features.orgselection.viewmodel.OrganizationSelectionViewModel
import org.koin.dsl.module

val organizationSelectionModule = module {
    factory { OrganizationSelectionViewModel() }
}