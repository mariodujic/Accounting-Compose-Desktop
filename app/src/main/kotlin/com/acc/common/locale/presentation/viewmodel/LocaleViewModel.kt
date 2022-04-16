package com.acc.common.locale.presentation.viewmodel

import com.acc.common.locale.presentation.model.Croatian
import com.acc.common.locale.presentation.model.English
import com.acc.common.locale.presentation.model.Locale
import com.navigation.Entry
import com.preferences.Preferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocaleViewModel(
    private val preferences: Preferences
) : Entry {

    private val storedLocaleValue = preferences.get(LOCALE_KEY, English::class.java.name)
    private val _selectedLocale = MutableStateFlow(
        if (storedLocaleValue == English::class.java.name) {
            English
        } else {
            Croatian
        }
    )
    val selectedLocale: StateFlow<Locale> = _selectedLocale

    fun updateSelectedLocale(locale: Locale) {
        _selectedLocale.tryEmit(locale)
        preferences.set(LOCALE_KEY, locale::class.java.name)
    }

    private companion object {
        const val LOCALE_KEY = "localeKey"
    }
}