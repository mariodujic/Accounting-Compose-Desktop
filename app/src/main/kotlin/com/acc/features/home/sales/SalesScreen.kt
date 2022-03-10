package com.acc.features.home.sales

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon

@Composable
fun SalesScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {

    }
}