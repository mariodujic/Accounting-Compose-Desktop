package com.preferences

import java.util.prefs.Preferences

class Preferences {

    private val preferences = Preferences.userNodeForPackage(this::class.java)

    fun <T> set(key: String, value: T) {
        when (value) {
            is Boolean -> preferences.putBoolean(key, value)
            is String -> preferences.put(key, value)
            is Float -> preferences.putFloat(key, value)
            is Long -> preferences.putLong(key, value)
            is Int -> preferences.putInt(key, value)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(key: String, defaultValue: T): T {
        return when (defaultValue) {
            is Boolean -> preferences.getBoolean(key, defaultValue)
            is String -> preferences.get(key, defaultValue)
            is Float -> preferences.getFloat(key, defaultValue)
            is Long -> preferences.getLong(key, defaultValue)
            is Int -> preferences.getInt(key, defaultValue)
            else -> throw IllegalArgumentException()
        } as T
    }

    fun remove(key: String) {
        preferences.remove(key)
    }
}