package com.acc.features.home.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.acc.common.components.AppIcon
import com.acc.features.home.viewmodel.HomeViewModel
import com.navigation.HomeRoute
import com.navigation.produce

@Composable
fun HomeScreen(navigateBack: () -> Unit) {

    val viewModel = produce<HomeViewModel>(HomeRoute)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = navigateBack) { AppIcon(imageVector = Icons.Default.ArrowBack) }
                }
            )
        }
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val screenWidth = this.constraints.maxWidth
            Row(modifier = Modifier.fillMaxWidth()) {
                HomeMenu(modifier = Modifier.menuWidth(screenWidth.dp))
                HomeContent(modifier = Modifier.weight(3f))
            }
        }
    }
}

@Stable
private fun Modifier.menuWidth(screenWidth: Dp): Modifier {
    val width = (screenWidth / 3)
    val maxWidth = 220.dp
    return this.width(minOf(width, maxWidth))
}