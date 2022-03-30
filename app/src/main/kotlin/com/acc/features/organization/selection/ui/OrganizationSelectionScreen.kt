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
import com.acc.common.ui.Strings.createOrganizationButton
import com.acc.common.ui.Strings.noOrganizationSelectedLabel
import com.acc.common.ui.Strings.organizationSelectionLabel
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import com.acc.navigation.OrganizationSelectionRoute
import com.navigation.produce

@Composable
fun OrganizationScreen(
    navigateCreateOrganization: () -> Unit,
    navigateHome: () -> Unit
) {

    val viewModel = produce<OrganizationSelectionViewModel>(OrganizationSelectionRoute)
    val selectedOrganization by viewModel.selectedOrganization.collectAsState()
    val hasSelectedOrganization by viewModel.hasSelectedOrganization.collectAsState()
    val organizations by viewModel.organizations.collectAsState()

    LaunchedEffect(hasSelectedOrganization) {
        if (hasSelectedOrganization) navigateHome()
    }

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
                        text = organizationSelectionLabel,
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.h5
                    )
                }
                Column(modifier = Modifier.padding(vertical = smallPadding, horizontal = largePadding)) {
                    Box {
                        OutlinedButton(
                            onClick = { showCompanies = true },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text(text = selectedOrganization?.name ?: noOrganizationSelectedLabel)
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
                            organizations.forEach {
                                DropdownMenuItem(onClick = {
                                    showCompanies = false
                                    viewModel.selectCompany(it)
                                }) {
                                    Text(text = it.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}