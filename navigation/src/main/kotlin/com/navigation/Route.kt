package com.navigation

sealed interface Route
object OrganizationSelectionRoute : Route
object CreateOrganizationRoute : Route
object HomeRoute : Route