package com.acc.features.home.partners.list.presentation.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon

@Composable
fun PartnersScreen(navigateAddPartner: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateAddPartner) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {
    }
}