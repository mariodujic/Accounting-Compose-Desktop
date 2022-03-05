package com.acc.features.orgselection.viewmodel

import com.acc.common.navigation.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Company(
    val name: String,
    val selected: Boolean
)

class OrganizationSelectionViewModel : ViewModel {

    val companies = arrayOf(
        Company(name = "Blue", selected = true),
        Company(name = "Axor", selected = false)
    )

    private val _selectedCompany = MutableStateFlow(companies.first { it.selected })
    val selectedCompany: StateFlow<Company> = _selectedCompany

    fun selectCompany(company: Company) {
        _selectedCompany.value = company
    }
}