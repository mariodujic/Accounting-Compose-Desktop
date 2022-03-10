package com.acc.features.home.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeMenuButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selected) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
        ),
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}