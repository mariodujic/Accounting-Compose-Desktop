package com.acc.features.home.expenses.add.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.components.AppTextField
import com.acc.common.locale.presentation.model.LocaleComposition
import com.acc.common.ui.largePadding
import com.acc.common.ui.mediumPadding
import com.acc.common.ui.smallPadding
import com.acc.features.home.expenses.add.presentation.viewmodel.AddExpenseViewModel
import com.acc.navigation.AddExpenseRoute
import com.navigation.produce

@Composable
fun AddExpenseScreen(
    viewModel: AddExpenseViewModel = produce(AddExpenseRoute),
    navigateBack: () -> Unit
) {
    val locale = LocaleComposition.current

    val accountNumber by viewModel.accountNumber.collectAsState()
    val expenseDescription by viewModel.expenseDescription.collectAsState()
    val connectedPartnerName by viewModel.partnerName.collectAsState(initial = locale.notSelectedLabel)
    var expandedPartners by remember { mutableStateOf(false) }
    val partners by viewModel.partners.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = locale.addExpenseToolbarTitle, style = MaterialTheme.typography.h3) },
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
                        label = locale.addExpenseAccount
                    )
                    AppTextField(
                        value = expenseDescription,
                        setValue = viewModel::setExpenseDescription,
                        label = locale.addExpenseAccount
                    )
                    Box {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(mediumPadding),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AppTextField(
                                value = connectedPartnerName ?: locale.notSelectedLabel,
                                enabled = false,
                                label = locale.connectPartnerLabel,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(onClick = { expandedPartners = true }) {
                                AppIcon(imageVector = Icons.Default.Add)
                            }
                        }
                        DropdownMenu(
                            expanded = expandedPartners,
                            onDismissRequest = { expandedPartners = false }
                        ) {
                            partners.forEach {
                                DropdownMenuItem(
                                    onClick = {
                                        expandedPartners = false
                                        viewModel.setPartner(it.id)
                                    }
                                ) {
                                    Text(text = it.name)
                                }
                            }
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(onClick = viewModel::addExpense) {
                            Text(text = locale.addExpense)
                        }
                    }
                }
            }
        }
    }
}