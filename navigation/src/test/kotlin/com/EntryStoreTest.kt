package com

import com.navigation.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.error.NoBeanDefFoundException
import org.koin.dsl.module

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EntryStoreTest {

    private class FakeEntry : Entry
    private class NonProvidedFakeEntry : Entry

    private val fakeModule = module {
        factory { FakeEntry() }
    }

    private val fakeRoute = object : Route {}

    @BeforeAll
    fun setUp() {
        startKoin {
            modules(fakeModule)
        }
    }

    @AfterAll
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `should add object to entryStore`() {
        val expectedEntry = produce<FakeEntry>(fakeRoute)
        assertTrue(entryStore.isNotEmpty())
        val actualStore = entryStore[0]
        val actualClassId = actualStore.classId
        val expectedClassId = FakeEntry::class.java.name
        assertEquals(actualClassId, expectedClassId)
        val actualRoute = actualStore.route
        val expectedRoute = fakeRoute
        assertEquals(actualRoute, expectedRoute)
        val actualEntry = actualStore.entry
        assertEquals(actualEntry, expectedEntry)
    }

    @Test
    fun `should remove object from entryStore`() {
        produce<FakeEntry>(fakeRoute)
        assertTrue(entryStore.isNotEmpty())
        popEntry(fakeRoute)
        assertTrue(entryStore.isEmpty())
    }

    @Test
    fun `should throw NoBeanDefFoundException when Entry not provided over Koin`() {
        assertThrows<NoBeanDefFoundException> {
            produce<NonProvidedFakeEntry>(fakeRoute)
        }
    }
}