package com.acc.features.main.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.acc.common.navigation.HomeRoute
import com.acc.common.navigation.OrganizationRoute
import com.acc.common.navigation.rememberNavigation
import com.acc.common.ui.theme.AppTheme
import com.acc.features.home.ui.HomeScreen
import com.acc.features.home.viewmodel.HomeViewModel
import com.acc.features.orgselection.ui.OrganizationScreen
import com.acc.features.orgselection.viewmodel.OrganizationSelectionViewModel

@Composable
fun Main() {

    val navigation = rememberNavigation(defaultRoute = OrganizationRoute(OrganizationSelectionViewModel()))
    val routes by navigation.routeStack.collectAsState(initial = null)

    AppTheme(useDarkTheme = false) {
        when (val route = routes) {
            is OrganizationRoute -> OrganizationScreen(route.viewModel) {
                navigation.navigate(HomeRoute(HomeViewModel()))
            }
            is HomeRoute -> HomeScreen(route.viewModel) {
                navigation.popLast()
            }
        }
    }
}
