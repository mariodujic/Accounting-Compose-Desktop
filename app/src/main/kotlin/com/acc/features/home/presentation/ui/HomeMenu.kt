package com.acc.features.home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.acc.common.ui.Strings.homeNavigationCharOfAccountsButton
import com.acc.common.ui.Strings.homeNavigationDashboardButton
import com.acc.common.ui.Strings.homeNavigationExpensesButton
import com.acc.common.ui.Strings.homeNavigationSalesButton
import com.acc.common.ui.smallPadding
import com.acc.features.home.navigation.CharOfAccounts
import com.acc.features.home.navigation.Dashboard
import com.acc.features.home.navigation.Expenses
import com.acc.features.home.navigation.Sales
import com.navigation.Route

@Composable
fun HomeMenu(
    currentRoute: Route,
    navigateDashboard: () -> Unit,
    navigateExpenses: () -> Unit,
    navigateSales: () -> Unit,
    navigateCharOfAccounts: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.LightGray,
        elevation = 3.dp,
        modifier = modifier.fillMaxSize().zIndex(5f)
    ) {
        Column(modifier = Modifier.padding(smallPadding)) {
            HomeMenuButton(
                text = homeNavigationDashboardButton,
                selected = currentRoute is Dashboard,
                onClick = navigateDashboard
            )
            HomeMenuButton(
                text = homeNavigationExpensesButton,
                selected = currentRoute is Expenses,
                onClick = navigateExpenses
            )
            HomeMenuButton(
                text = homeNavigationSalesButton,
                selected = currentRoute is Sales,
                onClick = navigateSales
            )
            HomeMenuButton(
                text = homeNavigationCharOfAccountsButton,
                selected = currentRoute is CharOfAccounts,
                onClick = navigateCharOfAccounts
            )
        }
    }
}