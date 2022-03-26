package com

import com.navigation.AppNavigation
import com.navigation.Navigation
import com.navigation.Route
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class NavigationTest {

    object FakeDefaultRoute : Route
    object FakeRoute : Route

    private lateinit var sut: Navigation

    @BeforeEach
    fun setUp() {
        sut = AppNavigation(defaultRoute = FakeDefaultRoute)
    }

    @Test
    fun `should return default route`() {
        val expectedRoute = FakeDefaultRoute
        val actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
    }

    @Test
    fun `should update route`() {
        var expectedRoute: Route = FakeDefaultRoute
        var actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
        sut.navigate(FakeRoute)
        expectedRoute = FakeRoute
        actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
    }

    @Test
    fun `should pop last route`() {
        sut.navigate(FakeRoute)
        var expectedRoute: Route = FakeRoute
        var actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
        sut.popLast()
        expectedRoute = FakeDefaultRoute
        actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
    }

    @Test
    fun `should pop to default route`() {
        sut.navigate(FakeRoute)
        var expectedRoute: Route = FakeRoute
        var actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
        sut.popTo(FakeDefaultRoute)
        expectedRoute = FakeDefaultRoute
        actualRoute = sut.routeStack.value
        assertEquals(expectedRoute, actualRoute)
    }

    @Test
    fun `should throw exception if route not in list`() {
        sut.navigate(FakeRoute)
        sut.popLast()
        assertThrows<IllegalStateException> {
            sut.popTo(FakeRoute)
        }
    }

    @Test
    fun `should not emit last Route if list is empty`() {
        sut.navigate(FakeRoute)
        sut.popLast()
        assertDoesNotThrow {
            sut.popLast()
        }
    }
}