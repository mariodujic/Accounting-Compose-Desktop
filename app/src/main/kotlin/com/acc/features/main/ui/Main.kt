package com.acc.features.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import com.acc.common.ui.AppTheme
import com.acc.features.home.presentation.ui.HomeScreen
import com.acc.common.theme.viewmodel.ThemeViewModel
import com.acc.features.organization.create.presentation.ui.CreateOrganizationScreen
import com.acc.features.organization.selection.ui.OrganizationScreen
import com.acc.features.settings.presentation.ui.SettingsScreen
import com.acc.navigation.*
import com.navigation.produce
import com.navigation.rememberNavigation

@Composable
fun Main() {

    val stateHolder = rememberSaveableStateHolder()
    val navigation = rememberNavigation(defaultRoute = OrganizationSelectionRoute)
    val route by navigation.routeStack.collectAsState()

    val themeViewModel: ThemeViewModel = produce(Root)
    val darkTheme by themeViewModel.darkTheme.collectAsState()

    AppTheme(useDarkTheme = darkTheme) {
        when (route) {
            is OrganizationSelectionRoute -> {
                stateHolder.removeState(Unit)
                OrganizationScreen(
                    navigateCreateOrganization = { navigation.navigate(CreateOrganizationRoute) },
                    navigateHome = { navigation.navigate(HomeRoute) }
                )
            }
            is HomeRoute -> {
                stateHolder.SaveableStateProvider(Unit) {
                    HomeScreen(
                        navigateSettings = { navigation.navigate(SettingsRoute) },
                        navigateBack = navigation::popLast
                    )
                }
            }
            is CreateOrganizationRoute -> CreateOrganizationScreen {
                navigation.popLast()
            }
            is SettingsRoute -> SettingsScreen {
                navigation.popLast()
            }
        }
    }
}
