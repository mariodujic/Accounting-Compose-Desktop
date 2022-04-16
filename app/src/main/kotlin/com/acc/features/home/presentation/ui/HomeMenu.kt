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
import com.acc.common.locale.presentation.model.LocaleComposition
import com.acc.common.ui.smallPadding
import com.acc.features.home.navigation.*
import com.navigation.Route

@Composable
fun HomeMenu(
    currentRoute: Route,
    navigateDashboard: () -> Unit,
    navigateExpenses: () -> Unit,
    navigateSales: () -> Unit,
    navigateCharOfAccounts: () -> Unit,
    navigatePartners: () -> Unit,
    modifier: Modifier = Modifier
) {
    val locale = LocaleComposition.current

    Surface(
        color = Color.LightGray,
        elevation = 3.dp,
        modifier = modifier.fillMaxSize().zIndex(5f)
    ) {
        Column(modifier = Modifier.padding(smallPadding)) {
            HomeMenuButton(
                text = locale.homeNavigationDashboardButton,
                selected = currentRoute is Dashboard,
                onClick = navigateDashboard
            )
            HomeMenuButton(
                text = locale.homeNavigationExpensesButton,
                selected = currentRoute is Expenses,
                onClick = navigateExpenses
            )
            HomeMenuButton(
                text = locale.homeNavigationSalesButton,
                selected = currentRoute is Sales,
                onClick = navigateSales
            )
            HomeMenuButton(
                text = locale.homeNavigationCharOfAccountsButton,
                selected = currentRoute is CharOfAccounts,
                onClick = navigateCharOfAccounts
            )
            HomeMenuButton(
                text = locale.homeNavigationPartnersButton,
                selected = currentRoute is Partners,
                onClick = navigatePartners
            )
        }
    }
}