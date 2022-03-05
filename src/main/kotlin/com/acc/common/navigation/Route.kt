package com.acc.common.navigation

import com.acc.features.home.viewmodel.HomeViewModel
import com.acc.features.orgselection.viewmodel.OrganizationSelectionViewModel

sealed interface Route
data class OrganizationRoute(val viewModel: OrganizationSelectionViewModel) : Route
data class HomeRoute(val viewModel: HomeViewModel) : Route