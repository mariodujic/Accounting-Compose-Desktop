package com.acc.features.home.chartofaccounts.list.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import com.acc.common.components.AppIcon
import com.acc.common.ui.mediumPadding
import com.acc.features.home.chartofaccounts.list.presentation.viewmodel.ChartOfAccountsViewModel
import com.acc.features.home.navigation.CharOfAccounts
import com.navigation.produce

@Composable
fun ChartOfAccountsScreen(
    viewModel: ChartOfAccountsViewModel = produce(CharOfAccounts),
    navigateAddAccount: () -> Unit
) {

    val accounts by viewModel.getAccounts.collectAsState(initial = emptyList())

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
                    horizontalArrangement = Arrangement.spacedBy(mediumPadding),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colors.surface.copy(
                                if (index % 2 == 0) 0.8f
                                else 0.5f
                            )

                        )
                        .padding(mediumPadding)
                ) {
                    Text(text = item.number)
                    Text(text = item.description)
                }
            }
        }
    }
}