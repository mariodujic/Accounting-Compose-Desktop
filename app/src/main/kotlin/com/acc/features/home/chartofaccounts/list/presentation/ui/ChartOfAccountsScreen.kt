package com.acc.features.home.chartofaccounts.list.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.acc.common.components.AppIcon
import com.acc.common.components.AppRowActions
import com.acc.common.ui.rowHeight
import com.acc.common.ui.smallPadding
import com.acc.features.home.chartofaccounts.list.presentation.viewmodel.ChartOfAccountsViewModel
import com.acc.features.home.navigation.CharOfAccounts
import com.navigation.produce

@Composable
fun ChartOfAccountsScreen(
    viewModel: ChartOfAccountsViewModel = produce(CharOfAccounts),
    navigateAddAccount: () -> Unit
) {

    val accounts by viewModel.accounts.collectAsState(initial = emptyList())
    val selectedAccount by viewModel.selectedAccount.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateAddAccount) {
                AppIcon(imageVector = Icons.Default.Add)
            }
        }
    ) {
        LazyColumn {
            itemsIndexed(accounts) { index, item ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(smallPadding),
                    modifier = Modifier
                        .clickable { viewModel.selectAccount(item) }
                        .fillMaxWidth()
                        .height(rowHeight)
                        .background(
                            MaterialTheme.colors.surface.copy(
                                if (selectedAccount?.id == item.id) 0.1f
                                else if (index % 2 == 0) 0.8f
                                else 0.5f
                            )

                        )
                ) {
                    Text(text = item.number, modifier = Modifier.padding(start = smallPadding))
                    Text(text = item.description)
                    Spacer(modifier = Modifier.weight(1f))
                    AppRowActions(
                        selected = selectedAccount?.id == item.id,
                        onDelete = { viewModel.deleteAccount(item.id) }
                    )
                }
            }
        }
    }
}