package com.acc.features.home.sales.list.presentation.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon

@Composable
fun SalesScreen(navigateAddSales: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateAddSales) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {

    }
}