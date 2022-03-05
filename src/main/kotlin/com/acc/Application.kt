package com.acc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.acc.features.main.ui.Main

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Main()
    }
}