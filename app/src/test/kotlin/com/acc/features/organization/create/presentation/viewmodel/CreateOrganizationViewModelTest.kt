package com.acc.features.organization.create.presentation.viewmodel

import com.acc.features.organization.create.presentation.result.CreateOrganizationResult
import com.acc.features.organization.fakes.DateUtilsFake
import com.acc.features.organization.fakes.OrganizationRepositoryFake
import com.acc.features.organization.model.Organization
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class CreateOrganizationViewModelTest {

    private val repository = OrganizationRepositoryFake()
    private val dateUtils = DateUtilsFake()
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)
    private lateinit var sut: CreateOrganizationViewModel

    @BeforeEach
    fun setUp() {
        sut = CreateOrganizationViewModel(
            repository = repository,
            dateUtils = dateUtils,
            ioCoroutineScope = testScope
        )
    }

    @Test
    fun `should return default CreateOrganizationResult`() {
        val expectedResult = CreateOrganizationResult.IDLE
        val actualResult = sut.result.value
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should return CreateOrganizationResult ERROR`() {
        val fakeOrganizationId = "a"
        val fakeOrganization = Organization(organizationId = fakeOrganizationId)
        runBlocking { repository.insertOrganization(fakeOrganization) }
        sut.createOrganization(fakeOrganizationId, "b", "c", "d")
        val expectedResult = CreateOrganizationResult.ERROR
        val actualResult = sut.result.value
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should return CreateOrganizationResult SUCCESS`() {
        val fakeOrganizationId = "a"
        sut.createOrganization(fakeOrganizationId, "b", "c", "d")
        val expectedResult = CreateOrganizationResult.SUCCESS
        val actualResult = sut.result.value
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `should add Organization`() {
        val fakeOrganizationId = "a"
        sut.createOrganization(fakeOrganizationId, "b", "c", "d")
        val organizationExists = runBlocking { repository.getOrganizations().first() }.any {
            it.organizationId == fakeOrganizationId
        }
        assertTrue(organizationExists)
    }
}