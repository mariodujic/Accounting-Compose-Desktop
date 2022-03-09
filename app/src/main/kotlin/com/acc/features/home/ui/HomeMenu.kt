package com.acc.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.acc.common.ui.smallPadding

@Composable
fun HomeMenu(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.LightGray).padding(smallPadding)) {
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Placeholder 1")
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Placeholder 2")
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Placeholder 3")
        }
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Placeholder 4")
        }
    }
}