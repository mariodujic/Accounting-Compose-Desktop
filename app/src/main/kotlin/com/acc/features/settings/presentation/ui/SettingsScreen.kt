package com.acc.features.settings.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.common.components.AppTextField
import com.acc.common.theme.viewmodel.ThemeViewModel
import com.acc.common.ui.Strings.reselectOrganizationButton
import com.acc.common.ui.Strings.settingsDarkThemeButton
import com.acc.common.ui.Strings.settingsToolbarTitle
import com.acc.common.ui.Strings.settingsVatRate
import com.acc.common.ui.Strings.settingsVatRateError
import com.acc.common.ui.mediumPadding
import com.acc.common.ui.smallPadding
import com.acc.features.settings.presentation.viewmodel.SettingsViewModel
import com.acc.navigation.RootRoute
import com.acc.navigation.SettingsRoute
import com.navigation.produce

@Composable
fun SettingsScreen(
    navigateOrganizationSelection: () -> Unit,
    navigateBack: () -> Unit
) {

    val settingsViewModel: SettingsViewModel = produce(SettingsRoute)
    var vatRate by remember { mutableStateOf<String?>(null) }
    val vatError by settingsViewModel.vatUpdateError.collectAsState()

    val themeViewModel: ThemeViewModel = produce(RootRoute)
    val darkTheme by themeViewModel.darkTheme.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = settingsToolbarTitle, style = MaterialTheme.typography.h3) },
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
            Card(modifier = Modifier.width(220.dp)) {
                Column(modifier = Modifier.padding(horizontal = mediumPadding, vertical = smallPadding)) {
                    Button(onClick = {
                        navigateOrganizationSelection()
                        settingsViewModel.unselectOrganizations()
                    }) {
                        Text(text = reselectOrganizationButton)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = settingsDarkThemeButton)
                        Checkbox(
                            checked = darkTheme,
                            onCheckedChange = { themeViewModel.toggleTheme() }
                        )
                    }
                    AppTextField(
                        value = vatRate ?: settingsViewModel.vatRate.toString(),
                        setValue = {
                            vatRate = it
                            settingsViewModel.storeVatRate(it)
                        },
                        label = settingsVatRate,
                        errorMessage = if (vatError) settingsVatRateError else null
                    )
                }
            }
        }
    }
}