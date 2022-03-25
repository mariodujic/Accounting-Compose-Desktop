package com.acc.features.home.chartofaccounts.add.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.components.AppTextField
import com.acc.common.ui.Strings
import com.acc.common.ui.Strings.addAccountDescriptionLabel
import com.acc.common.ui.Strings.addAccountNumberLabel
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding

@Composable
fun AddChartOfAccountScreen(navigateBack: () -> Unit) {

    var accountNumber by remember { mutableStateOf("") }
    var accountDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = Strings.addAccountToolbarTitle, style = MaterialTheme.typography.h3) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) { AppIcon(imageVector = Icons.Default.ArrowBack) }
                }
            )
        }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Card(modifier = Modifier.width(300.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(smallPadding),
                    modifier = Modifier.padding(largePadding)
                ) {
                    AppTextField(
                        value = accountNumber,
                        setValue = { accountNumber = it },
                        label = addAccountNumberLabel
                    )
                    AppTextField(
                        value = accountDescription,
                        setValue = { accountDescription = it },
                        label = addAccountDescriptionLabel
                    )
                }
            }
        }
    }
}