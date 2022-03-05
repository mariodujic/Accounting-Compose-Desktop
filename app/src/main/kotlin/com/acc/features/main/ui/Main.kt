package com.acc.features.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.navigation.HomeRoute
import com.navigation.OrganizationRoute
import com.navigation.rememberNavigation
import com.acc.common.ui.theme.AppTheme
import com.acc.features.home.ui.HomeScreen
import com.acc.features.orgselection.ui.OrganizationScreen

@Composable
fun Main() {

    val navigation = rememberNavigation(defaultRoute = OrganizationRoute)
    val routes by navigation.routeStack.collectAsState(initial = null)

    AppTheme(useDarkTheme = false) {
        when (routes) {
            is OrganizationRoute -> OrganizationScreen() {
                navigation.navigate(HomeRoute)
            }
            is HomeRoute -> HomeScreen {
                navigation.popLast()
            }
        }
    }
}
