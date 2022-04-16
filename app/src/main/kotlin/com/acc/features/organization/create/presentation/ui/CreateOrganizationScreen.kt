package com.acc.features.organization.create.presentation.ui

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
import com.acc.common.locale.presentation.model.LocaleComposition
import com.acc.common.ui.error
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding
import com.acc.features.organization.create.presentation.result.CreateOrganizationResult
import com.acc.features.organization.create.presentation.state.rememberOrganizationState
import com.acc.features.organization.create.presentation.viewmodel.CreateOrganizationViewModel
import com.acc.navigation.CreateOrganizationRoute
import com.navigation.produce

@Composable
fun CreateOrganizationScreen(
    viewModel: CreateOrganizationViewModel = produce(CreateOrganizationRoute),
    navigateBack: () -> Unit
) {

    val locale = LocaleComposition.current

    val organization = rememberOrganizationState()
    val result by viewModel.result.collectAsState()
    if (result == CreateOrganizationResult.SUCCESS) {
        navigateBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = locale.createOrganizationToolbarTitle, style = MaterialTheme.typography.h4) },
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
                    AppTextField(
                        value = organization.organizationId,
                        setValue = { organization.organizationId = it },
                        label = locale.organizationIdLabel
                    )
                    if (result == CreateOrganizationResult.ERROR) {
                        Text(text = locale.createOrganizationIdError, color = error)
                    }
                    AppTextField(
                        value = organization.name,
                        setValue = { organization.name = it },
                        label = locale.organizationNameLabel
                    )
                    AppTextField(
                        value = organization.postCode,
                        setValue = { organization.postCode = it },
                        label = locale.organizationPostCodeLabel
                    )
                    AppTextField(
                        value = organization.address,
                        setValue = { organization.address = it },
                        label = locale.organizationAddressLabel
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            enabled = organization.valid,
                            onClick = {
                                viewModel.createOrganization(
                                    organizationId = organization.organizationId,
                                    name = organization.name,
                                    postCode = organization.postCode,
                                    address = organization.address
                                )
                            }
                        ) {
                            Text(text = locale.createOrganizationButton)
                        }
                    }
                }
            }
        }
    }
}