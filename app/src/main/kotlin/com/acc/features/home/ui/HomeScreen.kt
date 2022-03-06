package com.acc.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.acc.common.ui.Strings.backButton
import com.navigation.HomeRoute
import com.navigation.produce
import com.acc.features.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navigateBack: () -> Unit) {

    val viewModel = produce<HomeViewModel>(HomeRoute)

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        Button(onClick = navigateBack) {
            Text(text = backButton)
        }
    }
}