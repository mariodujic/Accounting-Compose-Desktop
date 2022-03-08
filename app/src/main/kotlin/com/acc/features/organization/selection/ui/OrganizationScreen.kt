package com.acc.features.organization.selection.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.ui.Strings.companySelectionLabel
import com.acc.common.ui.Strings.createOrganizationButton
import com.acc.common.ui.Strings.enterButton
import com.acc.common.ui.mediumPadding
import com.acc.common.ui.smallPadding
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import com.navigation.OrganizationSelectionRoute
import com.navigation.produce

@Composable
fun OrganizationScreen(
    navigateCreateOrganization: () -> Unit,
    navigateHome: () -> Unit
) {

    val viewModel = produce<OrganizationSelectionViewModel>(OrganizationSelectionRoute)
    val selectedCompany by viewModel.selectedCompany.collectAsState()

    var showCompanies by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Card(modifier = Modifier.width(150.dp)) {
            Column {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = companySelectionLabel,
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.h5
                    )
                }
                Column(modifier = Modifier.padding(vertical = smallPadding, horizontal = mediumPadding)) {
                    Box {
                        OutlinedButton(
                            onClick = { showCompanies = true },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text(text = selectedCompany.name)
                                AppIcon(imageVector = if (showCompanies) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown)
                            }
                        }
                        DropdownMenu(
                            expanded = showCompanies,
                            onDismissRequest = { showCompanies = false }
                        ) {
                            Button(
                                onClick = navigateCreateOrganization,
                                modifier = Modifier.fillMaxWidth().padding(horizontal = smallPadding)
                            ) {
                                Text(text = createOrganizationButton)
                            }
                            viewModel.companies.forEach {
                                DropdownMenuItem(onClick = {
                                    showCompanies = false
                                    viewModel.selectCompany(it)
                                }) {
                                    Text(text = it.name)
                                }
                            }
                        }
                    }
                    Button(
                        onClick = navigateHome,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = enterButton)
                    }
                }
            }
        }
    }
}