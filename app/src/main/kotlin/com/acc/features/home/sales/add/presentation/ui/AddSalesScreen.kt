package com.acc.features.home.sales.add.presentation.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.acc.common.components.AppIcon
import com.acc.common.locale.presentation.model.LocaleComposition

@Composable
fun AddSalesScreen(navigateBack: () -> Unit) {

    val locale = LocaleComposition.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = locale.addSalesToolbarTitle, style = MaterialTheme.typography.h3) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) { AppIcon(imageVector = Icons.Default.ArrowBack) }
                }
            )
        }
    ) {

    }
}