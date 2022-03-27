package com.acc.features.home.chartofaccounts.add.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.components.AppTextField
import com.acc.common.ui.Strings
import com.acc.common.ui.Strings.addAccount
import com.acc.common.ui.Strings.addAccountDescriptionLabel
import com.acc.common.ui.Strings.addAccountNumberLabel
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding
import com.acc.features.home.chartofaccounts.add.presentation.viewmodel.AddChartOfAccountsViewModel
import com.acc.navigation.AddChartOfAccountRoute
import com.navigation.produce

@Composable
fun AddChartOfAccountScreen(
    viewModel: AddChartOfAccountsViewModel = produce(AddChartOfAccountRoute),
    navigateBack: () -> Unit
) {

    val accountNumber by viewModel.accountNumber.collectAsState()
    val accountDescription by viewModel.accountDescription.collectAsState()
    val accountValid by viewModel.accountValid.collectAsState(initial = false)

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
                        setValue = viewModel::setAccountNumber,
                        label = addAccountNumberLabel
                    )
                    AppTextField(
                        value = accountDescription,
                        setValue = viewModel::setAccountDescription,
                        label = addAccountDescriptionLabel
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            enabled = accountValid,
                            onClick = viewModel::addChartAccount
                        ) {
                            Text(text = addAccount)
                        }
                    }
                }
            }
        }
    }
}