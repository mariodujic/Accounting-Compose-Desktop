package com.navigation

import org.koin.java.KoinJavaComponent

@PublishedApi
internal val entryStore: MutableList<Store> = mutableListOf()

@PublishedApi
internal val koin = KoinJavaComponent.getKoin()

inline fun <reified T : Entry> produce(route: Route): T {
    val classId = T::class.java.name
    if (!entryStore.any { it.classId == classId && it.route == route }) {
        entryStore.add(
            Store(
                classId = classId,
                route = route,
                entry = koin.get(T::class)
            )
        )
    }
    return entryStore.first { it.classId == classId && it.route == route }.entry as T
}

internal fun popEntry(route: Route) {
    entryStore.removeAll { it.route == route }
}