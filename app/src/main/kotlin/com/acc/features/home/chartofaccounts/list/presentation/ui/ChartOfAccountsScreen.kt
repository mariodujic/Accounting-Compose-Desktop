package com.acc.features.home.chartofaccounts.list.presentation.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon

@Composable
fun ChartOfAccountsScreen(navigateAddAccount: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateAddAccount) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {

    }
}