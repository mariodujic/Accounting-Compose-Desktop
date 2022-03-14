package com.acc.features.settings.presentation.ui

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
import com.acc.common.ui.Strings.settingsDarkThemeButton
import com.acc.common.ui.Strings.settingsToolbarTitle
import com.acc.common.ui.mediumPadding
import com.acc.common.theme.viewmodel.ThemeViewModel
import com.acc.navigation.Root
import com.navigation.produce

@Composable
fun SettingsScreen(navigateBack: () -> Unit) {

    val themeViewModel: ThemeViewModel = produce(Root)
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
            Card {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(mediumPadding)
                ) {
                    Text(text = settingsDarkThemeButton)
                    Checkbox(
                        checked = darkTheme,
                        onCheckedChange = { themeViewModel.toggleTheme() }
                    )
                }
            }
        }
    }
}