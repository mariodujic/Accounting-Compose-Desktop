package com.acc.features.home.presentation.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.features.home.dashboard.DashboardScreen
import com.acc.features.home.expenses.list.presentation.ui.ExpensesScreen
import com.acc.features.home.navigation.Dashboard
import com.acc.features.home.navigation.Expenses
import com.acc.features.home.navigation.Sales
import com.acc.features.home.presentation.viewmodel.HomeViewModel
import com.acc.features.home.sales.SalesScreen
import com.acc.navigation.HomeRoute
import com.navigation.produce
import com.navigation.rememberNavigation

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = produce(HomeRoute),
    navigateAddExpense: () -> Unit,
    navigateSettings: () -> Unit,
    navigateBack: () -> Unit
) {

    val homeNavigation = rememberNavigation(defaultRoute = Dashboard)
    val route by homeNavigation.routeStack.collectAsState()

    val toolbarTitle by viewModel.selectedOrganizationName.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = toolbarTitle, style = MaterialTheme.typography.h3) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) { AppIcon(imageVector = Icons.Default.ArrowBack) }
                },
                actions = {
                    IconButton(onClick = navigateSettings) { AppIcon(imageVector = Icons.Default.Settings) }
                }
            )
        }
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val screenWidth = this.constraints.maxWidth
            Row(modifier = Modifier.fillMaxWidth()) {
                HomeMenu(
                    currentRoute = route,
                    navigateDashboard = { homeNavigation.navigate(Dashboard) },
                    navigateExpenses = { homeNavigation.navigate(Expenses) },
                    navigateSales = { homeNavigation.navigate(Sales) },
                    modifier = Modifier.menuWidth(screenWidth.dp)
                )
                HomeContent(modifier = Modifier.weight(3f)) {
                    when (route) {
                        is Dashboard -> DashboardScreen()
                        is Expenses -> ExpensesScreen(navigateAddExpense = navigateAddExpense)
                        is Sales -> SalesScreen()
                    }
                }
            }
        }
    }
}

@Stable
private fun Modifier.menuWidth(screenWidth: Dp): Modifier {
    val width = (screenWidth / 3)
    val maxWidth = 220.dp
    return this.width(minOf(width, maxWidth))
}