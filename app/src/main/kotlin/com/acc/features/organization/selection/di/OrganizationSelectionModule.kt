package com.acc.features.organization.selection.di

import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import org.koin.dsl.module

val organizationSelectionModule = module {
    factory { OrganizationSelectionViewModel() }
}