package com.acc.features.home.partners.add.presentation.ui

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
import com.acc.common.ui.Strings.addPartnerButton
import com.acc.common.ui.Strings.addPartnerToolbarTitle
import com.acc.common.ui.Strings.partnerAddressLabel
import com.acc.common.ui.Strings.partnerNameLabel
import com.acc.common.ui.Strings.partnerPhoneNumberLabel
import com.acc.common.ui.largePadding
import com.acc.common.ui.smallPadding
import com.acc.features.home.partners.add.presentation.viewmodel.AddPartnerViewModel
import com.acc.navigation.AddPartnerRoute
import com.navigation.produce

@Composable
fun AddPartnerScreen(
    viewModel: AddPartnerViewModel = produce(AddPartnerRoute),
    navigateBack: () -> Unit
) {

    val partnerName by viewModel.partnerName.collectAsState()
    val partnerAddress by viewModel.partnerAddress.collectAsState()
    val partnerPhoneNumber by viewModel.partnerPhoneNumber.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = addPartnerToolbarTitle, style = MaterialTheme.typography.h3) },
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
                        value = partnerName,
                        setValue = viewModel::setPartnerName,
                        label = partnerNameLabel
                    )
                    AppTextField(
                        value = partnerAddress,
                        setValue = viewModel::setPartnerAddress,
                        label = partnerAddressLabel
                    )
                    AppTextField(
                        value = partnerPhoneNumber,
                        setValue = viewModel::setPartnerPhoneNumber,
                        label = partnerPhoneNumberLabel
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(onClick = viewModel::addPartner) {
                            Text(text = addPartnerButton)
                        }
                    }
                }
            }
        }
    }
}