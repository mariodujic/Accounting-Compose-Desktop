package com.acc.features.organization.selection.viewmodel

import com.acc.features.organization.fakes.OrganizationRepositoryFake
import com.acc.testutils.organizationFake
import com.acc.features.organization.selection.viewmodel.OrganizationSelectionViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class OrganizationSelectionViewModelTest {

    private val organizationRepository = OrganizationRepositoryFake()
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)
    private lateinit var sut: OrganizationSelectionViewModel

    @BeforeEach
    fun setUp() {
        sut = OrganizationSelectionViewModel(
            organizationRepository = organizationRepository,
            ioCoroutineScope = testScope
        )
    }

    @Test
    fun `should return organization list`() {
        runBlocking { organizationRepository.insertOrganization(organizationFake) }
        val expectedList = listOf(organizationFake)
        val actualList = runBlocking { sut.organizations.first() }
        assertEquals(expectedList, actualList)
    }

    @Test
    fun `should select organization`() {
        runBlocking { organizationRepository.insertOrganization(organizationFake) }
        var organizations = runBlocking { sut.organizations.first() }
        var organization = organizations[0]
        var organizationSelected = organization.selected
        assertFalse(organizationSelected)
        sut.selectOrganization(organization)
        organizations = runBlocking { sut.organizations.first() }
        organization = organizations[0]
        organizationSelected = organization.selected
        assertTrue(organizationSelected)
    }

    @Test
    fun `should return selected organization`() {
        runBlocking { organizationRepository.insertOrganization(organizationFake) }
        sut.selectOrganization(organizationFake)
        val expectedOrganization = organizationFake.copy(selected = true)
        val actualOrganization = runBlocking { sut.selectedOrganization.first() }
        assertEquals(expectedOrganization, actualOrganization)
    }

    @Test
    fun `should return true as organization is selected`() {
        runBlocking { organizationRepository.insertOrganization(organizationFake) }
        sut.selectOrganization(organizationFake)
        assertTrue(runBlocking { sut.hasSelectedOrganization.first() })
    }
}