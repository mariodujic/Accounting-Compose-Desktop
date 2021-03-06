package com.acc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.acc.common.di.coroutinesModule
import com.acc.common.locale.di.localeModule
import com.acc.common.theme.di.themeModule
import com.acc.features.home.chartofaccounts.di.chartOfAccountsModule
import com.acc.features.home.expenses.di.expensesModule
import com.acc.features.home.partners.di.partnersModule
import com.acc.features.home.presentation.di.homeModule
import com.acc.features.main.ui.Main
import com.acc.features.organization.di.organizationModule
import com.acc.features.settings.di.settingsModule
import com.database.databaseModule
import com.preferences.preferencesModule
import com.utils.utilsModule
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
            coroutinesModule,
            preferencesModule,
            themeModule,
            expensesModule,
            chartOfAccountsModule,
            partnersModule,
            localeModule,
            settingsModule
        )
    }
}