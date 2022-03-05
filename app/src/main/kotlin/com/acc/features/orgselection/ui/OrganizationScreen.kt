package com.acc.features.orgselection.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.navigation.OrganizationRoute
import com.acc.common.ui.theme.mediumPadding
import com.acc.common.ui.theme.smallPadding
import com.navigation.produce
import com.acc.features.orgselection.viewmodel.OrganizationSelectionViewModel

@Composable
fun OrganizationScreen(navigateHomeScreen: () -> Unit) {

    val viewModel = produce<OrganizationSelectionViewModel>(OrganizationRoute)
    val selectedCompany by viewModel.selectedCompany.collectAsState()

    var showCompanies by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        Card(modifier = Modifier.width(200.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(mediumPadding)
            ) {
                Text(
                    text = selectedCompany.name,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(smallPadding))
                Button(onClick = { showCompanies = true }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Switch company")
                }
                DropdownMenu(
                    expanded = showCompanies,
                    onDismissRequest = { showCompanies = false },
                    modifier = Modifier.width(200.dp)
                ) {
                    viewModel.companies.forEach {
                        DropdownMenuItem(onClick = {
                            showCompanies = false
                            viewModel.selectCompany(it)
                        }) {
                            Text(text = it.name)
                        }
                    }
                }
                Button(onClick = navigateHomeScreen, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Select")
                }
            }
        }
    }
}