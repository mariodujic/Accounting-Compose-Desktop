package com.acc.features.organization.di

import com.acc.features.organization.create.viewmodel.CreateOrganizationViewModel
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import org.koin.dsl.module

val organizationModule = module {
    factory { OrganizationSelectionViewModel() }
    factory { CreateOrganizationViewModel() }
}