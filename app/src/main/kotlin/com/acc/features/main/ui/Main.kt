package com.acc.features.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import com.acc.common.theme.viewmodel.ThemeViewModel
import com.acc.common.ui.AppTheme
import com.acc.features.home.chartofaccounts.add.presentation.ui.AddChartOfAccountScreen
import com.acc.features.home.expenses.add.presentation.ui.AddExpenseScreen
import com.acc.features.home.presentation.ui.HomeScreen
import com.acc.features.home.sales.add.presentation.ui.AddSalesScreen
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

    val themeViewModel: ThemeViewModel = produce(RootRoute)
    val darkTheme by themeViewModel.darkTheme.collectAsState()

    AppTheme(useDarkTheme = darkTheme) {
        when (route) {
            is OrganizationSelectionRoute -> {
                stateHolder.removeState(Unit)
                OrganizationScreen(
                    navigateCreateOrganization = { navigation.navigate(CreateOrganizationRoute) },
                    navigateHome = {
                        navigation.popLast()
                        navigation.navigate(HomeRoute)
                    }
                )
            }
            is HomeRoute -> {
                stateHolder.SaveableStateProvider(Unit) {
                    HomeScreen(
                        navigateAddExpense = { navigation.navigate(AddExpenseRoute) },
                        navigateAddSales = { navigation.navigate(AddSalesRoute) },
                        navigateAddAccount = { navigation.navigate(AddChartOfAccountRoute) },
                        navigateSettings = { navigation.navigate(SettingsRoute) }
                    )
                }
            }
            is AddExpenseRoute -> AddExpenseScreen(navigateBack = navigation::popLast)
            is AddSalesRoute -> AddSalesScreen(navigateBack = navigation::popLast)
            is AddChartOfAccountRoute -> AddChartOfAccountScreen(navigateBack = navigation::popLast)
            is CreateOrganizationRoute -> CreateOrganizationScreen {
                navigation.popLast()
            }
            is SettingsRoute -> SettingsScreen(
                navigateOrganizationSelection = { navigation.navigateAsRoot(OrganizationSelectionRoute) },
                navigateBack = navigation::popLast
            )
        }
    }
}
