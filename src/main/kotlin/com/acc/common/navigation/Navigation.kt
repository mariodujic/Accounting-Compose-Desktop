package com.acc.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun rememberNavigation(defaultRoute: Route): Navigation {
    return remember { AppNavigation(defaultRoute = defaultRoute) }
}

class AppNavigation(defaultRoute: Route) : Navigation {

    private val routes: MutableList<Route> = mutableListOf(defaultRoute)
    private val _routeStack: MutableSharedFlow<Route> = MutableStateFlow(defaultRoute)
    override val routeStack: SharedFlow<Route> = _routeStack

    override fun navigate(route: Route) {
        routes.add(route)
        _routeStack.tryEmit(routes.last())
    }

    override fun popLast() {
        routes.removeLast()
        _routeStack.tryEmit(routes.last())
    }

}

interface Navigation {
    val routeStack: SharedFlow<Route>
    fun navigate(route: Route)
    fun popLast()
}