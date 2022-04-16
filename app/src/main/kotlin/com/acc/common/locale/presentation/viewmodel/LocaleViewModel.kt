package com.acc.common.locale.presentation.viewmodel

import com.acc.common.locale.presentation.model.English
import com.acc.common.locale.presentation.model.Locale
import com.navigation.Entry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LocaleViewModel : Entry {

    private val _selectedLocale = MutableStateFlow<Locale>(English)
    val selectedLocale: StateFlow<Locale> = _selectedLocale

    fun updateSelectedLocale(locale: Locale) {
        _selectedLocale.tryEmit(locale)
    }
}