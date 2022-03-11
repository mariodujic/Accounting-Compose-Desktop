package com.acc.features.organization.di

import com.acc.features.organization.data.local.dao.OrganizationDao
import com.acc.features.organization.data.local.dao.OrganizationDaoImpl
import com.acc.features.organization.data.repository.OrganizationRepository
import com.acc.features.organization.create.presentation.viewmodel.CreateOrganizationViewModel
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import org.koin.dsl.module

val organizationModule = module {
    factory { OrganizationSelectionViewModel(get(), get()) }
    factory { CreateOrganizationViewModel(get(), get()) }
    single { OrganizationRepository(get()) }
    single<OrganizationDao> { OrganizationDaoImpl(get(), get()) }
}