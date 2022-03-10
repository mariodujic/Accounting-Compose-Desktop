package com.acc.features.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.acc.common.ui.AppTheme
import com.acc.features.home.presentation.ui.HomeScreen
import com.acc.features.organization.create.ui.CreateOrganizationScreen
import com.acc.features.organization.selection.ui.OrganizationScreen
import com.acc.navigation.CreateOrganizationRoute
import com.acc.navigation.HomeRoute
import com.acc.navigation.OrganizationSelectionRoute
import com.navigation.rememberNavigation

@Composable
fun Main() {

    val navigation = rememberNavigation(defaultRoute = OrganizationSelectionRoute)
    val route by navigation.routeStack.collectAsState()

    AppTheme(useDarkTheme = false) {
        when (route) {
            is OrganizationSelectionRoute -> OrganizationScreen(
                navigateCreateOrganization = { navigation.navigate(CreateOrganizationRoute) },
                navigateHome = { navigation.navigate(HomeRoute) }
            )
            is HomeRoute -> HomeScreen {
                navigation.popLast()
            }
            is CreateOrganizationRoute -> CreateOrganizationScreen {
                navigation.popLast()
            }
        }
    }
}
