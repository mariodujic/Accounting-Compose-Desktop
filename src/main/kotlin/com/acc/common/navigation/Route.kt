package com.acc.common.navigation

import com.acc.features.home.viewmodel.HomeViewModel
import com.acc.features.orgselection.viewmodel.OrganizationSelectionViewModel
import org.koin.java.KoinJavaComponent.getKoin

private val koin = getKoin()

sealed interface Route
data class OrganizationRoute(
    val viewModel: OrganizationSelectionViewModel = koin.get()
) : Route

data class HomeRoute(
    val viewModel: HomeViewModel = koin.get()
) : Route