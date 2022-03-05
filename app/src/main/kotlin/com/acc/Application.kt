package com.acc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.acc.features.home.di.homeModule
import com.acc.features.main.ui.Main
import com.acc.features.orgselection.di.organizationSelectionModule
import org.koin.core.context.startKoin

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        initializeKoinDependencies()
        Main()
    }
}

private fun initializeKoinDependencies() {
    startKoin {
        modules(
            organizationSelectionModule,
            homeModule
        )
    }
}