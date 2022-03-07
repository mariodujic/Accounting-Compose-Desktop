package com.acc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.acc.features.home.di.homeModule
import com.acc.features.main.ui.Main
import com.acc.features.organization.selection.di.organizationSelectionModule
import com.database.databaseModule
import org.koin.core.context.startKoin

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        addKoinModules()
        Main()
    }
}

private fun addKoinModules() {
    startKoin {
        modules(
            organizationSelectionModule,
            homeModule,
            databaseModule
        )
    }
}