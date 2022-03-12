package com.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun rememberNavigation(defaultRoute: Route): Navigation {
    return rememberSaveable { AppNavigation(defaultRoute = defaultRoute) }
}

private class AppNavigation(defaultRoute: Route) : Navigation {

    private val routes: MutableList<Route> = mutableListOf(defaultRoute)
    private val _routeStack: MutableStateFlow<Route> = MutableStateFlow(defaultRoute)
    override val routeStack: StateFlow<Route> = _routeStack

    override fun navigate(route: Route) {
        routes.add(route)
        _routeStack.tryEmit(routes.last())
    }

    override fun popLast() {
        popEntry(routes.last())
        routes.removeLast()
        _routeStack.tryEmit(routes.last())
    }
}

interface Navigation {
    val routeStack: StateFlow<Route>
    fun navigate(route: Route)
    fun popLast()
}