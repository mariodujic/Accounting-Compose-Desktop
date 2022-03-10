package com.acc.features.organization.di

import com.acc.features.organization.create.data.local.dao.CreateOrganizationDao
import com.acc.features.organization.create.data.local.dao.CreateOrganizationDaoImpl
import com.acc.features.organization.create.data.repository.CreateOrganizationRepository
import com.acc.features.organization.create.presentation.viewmodel.CreateOrganizationViewModel
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import org.koin.dsl.module

val organizationModule = module {
    factory { OrganizationSelectionViewModel() }
    factory { CreateOrganizationViewModel(get(), get()) }
    factory { CreateOrganizationRepository(get()) }
    single<CreateOrganizationDao> { CreateOrganizationDaoImpl(get(), get()) }
}