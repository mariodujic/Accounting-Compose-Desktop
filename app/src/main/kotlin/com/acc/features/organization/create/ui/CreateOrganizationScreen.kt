package com.acc.features.organization.create.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.ui.Strings.createOrganizationButton
import com.acc.common.ui.Strings.createOrganizationToolbarTitle
import com.acc.common.ui.Strings.organizationAddressLabel
import com.acc.common.ui.Strings.organizationIdLabel
import com.acc.common.ui.Strings.organizationNameLabel
import com.acc.common.ui.Strings.organizationPostCodeLabel
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding
import com.acc.features.organization.create.state.rememberOrganizationState
import com.acc.features.organization.create.viewmodel.CreateOrganizationViewModel
import com.navigation.CreateOrganizationRoute
import com.navigation.produce

@Composable
fun CreateOrganizationScreen(
    viewModel: CreateOrganizationViewModel = produce(CreateOrganizationRoute),
    navigateBack: () -> Unit
) {

    val organization = rememberOrganizationState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = createOrganizationToolbarTitle, style = MaterialTheme.typography.h4) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) { AppIcon(imageVector = Icons.Default.ArrowBack) }
                }
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(modifier = Modifier.width(300.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(smallPadding),
                    modifier = Modifier.padding(horizontal = largePadding, vertical = smallPadding)
                ) {
                    CreateOrganizationField(
                        value = organization.id,
                        setValue = { organization.id = it },
                        label = organizationIdLabel
                    )
                    CreateOrganizationField(
                        value = organization.name,
                        setValue = { organization.name = it },
                        label = organizationNameLabel
                    )
                    CreateOrganizationField(
                        value = organization.postCode,
                        setValue = { organization.postCode = it },
                        label = organizationPostCodeLabel
                    )
                    CreateOrganizationField(
                        value = organization.address,
                        setValue = { organization.address = it },
                        label = organizationAddressLabel
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            enabled = organization.valid,
                            onClick = {
                                viewModel.createOrganization(
                                    id = organization.id,
                                    name = organization.name,
                                    postalCode = organization.postCode,
                                    address = organization.address
                                )
                            }
                        ) {
                            Text(text = createOrganizationButton)
                        }
                    }
                }
            }
        }
    }
}