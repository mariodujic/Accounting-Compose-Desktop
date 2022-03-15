package com.acc.features.home.expenses.list.presentation.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon

@Composable
fun ExpensesScreen(navigateAddExpense: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateAddExpense) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {

    }
}