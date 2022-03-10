package com.acc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.acc.common.di.coroutinesModule
import com.acc.features.home.presentation.di.homeModule
import com.acc.features.main.ui.Main
import com.acc.features.organization.di.organizationModule
import com.acc.utils.utilsModule
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
            organizationModule,
            homeModule,
            databaseModule,
            utilsModule,
            coroutinesModule
        )
    }
}