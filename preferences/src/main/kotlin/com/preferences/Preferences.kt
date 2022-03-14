package com.preferences

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class Preferences {

    private val preferences = Preferences.userNodeForPackage(this::class.java)

    /**
     * Used to emit latest [getFlow] value. Whenever [set] is called
     * [getFlow] will emit the latest value for a given key.
     */
    private val updater: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>(1).also {
        it.tryEmit(Unit)
    }

    fun <T> set(key: String, value: T) {
        when (value) {
            is Boolean -> preferences.putBoolean(key, value)
            is String -> preferences.put(key, value)
            is Float -> preferences.putFloat(key, value)
            is Long -> preferences.putLong(key, value)
            is Int -> preferences.putInt(key, value)
        }
        updater.tryEmit(Unit)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String, defaultValue: T): T {
        return getPreferenceValue(defaultValue, key) as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getFlow(key: String, defaultValue: T): Flow<T> {
        return updater.map {
            getPreferenceValue(defaultValue, key) as T
        }
    }

    private fun <T> getPreferenceValue(defaultValue: T, key: String) = when (defaultValue) {
        is Boolean -> preferences.getBoolean(key, defaultValue)
        is String -> preferences.get(key, defaultValue)
        is Float -> preferences.getFloat(key, defaultValue)
        is Long -> preferences.getLong(key, defaultValue)
        is Int -> preferences.getInt(key, defaultValue)
        else -> throw IllegalArgumentException()
    }

    fun remove(key: String) {
        preferences.remove(key)
    }
}