package com.navigation

import org.koin.java.KoinJavaComponent

val viewModelStore: MutableList<Store> = mutableListOf()
val koin = KoinJavaComponent.getKoin()

inline fun <reified T : Entry> produce(route: Route): T {
    val jClass = T::class.java
    val classId = jClass.name

    if (!viewModelStore.any { it.classId == classId && it.route == route }) {
        viewModelStore.add(
            Store(
                classId = classId,
                route = route,
                entry = koin.get(T::class)
            )
        )
    }
    return viewModelStore.first { it.classId == classId && it.route == route }.entry as T
}

fun popViewModel(route: Route) {
    viewModelStore.removeAll { it.route == route }
}