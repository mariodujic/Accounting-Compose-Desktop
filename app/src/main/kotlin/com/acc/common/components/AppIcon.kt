package com.acc.common.components

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppIcon(imageVector: ImageVector, tint: Color = LocalContentColor.current) {
    Icon(imageVector = imageVector, tint = tint, contentDescription = "")
}