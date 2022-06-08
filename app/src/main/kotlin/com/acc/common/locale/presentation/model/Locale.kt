package com.acc.common.locale.presentation.model

interface Locale {
    /*Common*/
    val backButton: String
    val editButton: String
    val notSelectedLabel: String
    val language: String

    /*Organization selection*/
    val organizationSelectionLabel: String
    val enterButton: String
    val noOrganizationSelectedLabel: String

    /*Create organization*/
    val createOrganizationButton: String
    val createOrganizationToolbarTitle: String
    val createOrganizationIdError: String
    val organizationIdLabel: String
    val organizationNameLabel: String
    val organizationPostCodeLabel: String
    val organizationAddressLabel: String

    /*Home*/
    val homeNavigationDashboardButton: String
    val homeNavigationExpensesButton: String
    val homeNavigationSalesButton: String
    val homeNavigationCharOfAccountsButton: String
    val homeNavigationPartnersButton: String

    /*Add expense*/
    val addExpenseToolbarTitle: String
    val addExpense: String
    val addExpenseAccount: String
    val addExpenseDescription: String

    /*Add sales*/
    val addSalesToolbarTitle: String

    /*Add CoA*/
    val addAccountToolbarTitle: String
    val addAccountNumberLabel: String
    val addAccountDescriptionLabel: String
    val connectPartnerLabel: String
    val addAccount: String
    val addChartAccountNumberError: String

    /*Add partner*/
    val addPartnerToolbarTitle: String
    val partnerNameLabel: String
    val partnerAddressLabel: String
    val partnerPhoneNumberLabel: String
    val addPartnerButton: String

    /*Settings*/
    val settingsToolbarTitle: String
    val settingsDarkThemeButton: String
    val reselectOrganizationButton: String
    val settingsVatRate: String
    val settingsVatRateError: String
    val settingsLanguage: String
}

object English : Locale {
    /*Common*/
    override val backButton = "Back"
    override val editButton = "Edit"
    override val notSelectedLabel = "Not selected"
    override val language = "English"

    /*Organization selection*/
    override val organizationSelectionLabel = "Organization"
    override val enterButton = "Enter"
    override val noOrganizationSelectedLabel = "Select"

    /*Create organization*/
    override val createOrganizationButton = "Create"
    override val createOrganizationToolbarTitle = "Create Organization"
    override val createOrganizationIdError = "Organization ID already exists."
    override val organizationIdLabel = "Organization ID"
    override val organizationNameLabel = "Name"
    override val organizationPostCodeLabel = "Post code"
    override val organizationAddressLabel = "Address"

    /*Home*/
    override val homeNavigationDashboardButton = "Dashboard"
    override val homeNavigationExpensesButton = "Expenses"
    override val homeNavigationSalesButton = "Sales"
    override val homeNavigationCharOfAccountsButton = "Chart of Accounts"
    override val homeNavigationPartnersButton = "Partners"

    /*Add expense*/
    override val addExpenseToolbarTitle = "Add expense"
    override val addExpense = "Add expense"
    override val addExpenseAccount = "Expense number"
    override val addExpenseDescription = "Expense description"

    /*Add sales*/
    override val addSalesToolbarTitle = "Add sales"

    /*Add CoA*/
    override val addAccountToolbarTitle = "Add account"
    override val addAccountNumberLabel = "Number"
    override val addAccountDescriptionLabel = "Description"
    override val connectPartnerLabel = "Connect partner"
    override val addAccount = "Add Account"
    override val addChartAccountNumberError = "Number is taken."

    /*Add partner*/
    override val addPartnerToolbarTitle = "Add partner"
    override val partnerNameLabel = "Name"
    override val partnerAddressLabel = "Address"
    override val partnerPhoneNumberLabel = "Phone number"
    override val addPartnerButton = "Add"

    /*Settings*/
    override val settingsToolbarTitle = "Settings"
    override val settingsDarkThemeButton = "Dark theme"
    override val reselectOrganizationButton = "Reselect organization"
    override val settingsVatRate = "VAT rate %"
    override val settingsVatRateError = "Invalid VAT number."
    override val settingsLanguage = "Language"
}

object Croatian : Locale {
    /*Common*/
    override val backButton = "Nazad"
    override val editButton = "Promijeni"
    override val notSelectedLabel = "Nije odabrano"
    override val language = "Hrvatski"

    /*Organization selection*/
    override val organizationSelectionLabel = "Organizacija"
    override val enterButton = "Pristupi"
    override val noOrganizationSelectedLabel = "Odaberi"

    /*Create organization*/
    override val createOrganizationButton = "Dodaj"
    override val createOrganizationToolbarTitle = "Dodaj organizaciju"
    override val createOrganizationIdError = "ID organizacije već postoji."
    override val organizationIdLabel = "ID organizacije"
    override val organizationNameLabel = "Ime"
    override val organizationPostCodeLabel = "Poštanski broj"
    override val organizationAddressLabel = "Adresa"

    /*Home*/
    override val homeNavigationDashboardButton = "Temeljnica"
    override val homeNavigationExpensesButton = "Ulazni računi"
    override val homeNavigationSalesButton = "Izlazni računi"
    override val homeNavigationCharOfAccountsButton = "Konta"
    override val homeNavigationPartnersButton = "Partneri"

    /*Add expense*/
    override val addExpenseToolbarTitle = "Dodaj ulazni račun"
    override val addExpense = "Dodaj trošak"
    override val addExpenseAccount = "Konto"
    override val addExpenseDescription = "Opis"

    /*Add sales*/
    override val addSalesToolbarTitle = "Dodaj izlazni račun"

    /*Add CoA*/
    override val addAccountToolbarTitle = "Dodaj konto"
    override val addAccountNumberLabel = "Broj"
    override val addAccountDescriptionLabel = "Opis"
    override val connectPartnerLabel = "Povezani partner"
    override val addAccount = "Dodaj konto"
    override val addChartAccountNumberError = "Broj je već korišten."

    /*Add partner*/
    override val addPartnerToolbarTitle = "Dodaj partnera"
    override val partnerNameLabel = "Ime"
    override val partnerAddressLabel = "Adresa"
    override val partnerPhoneNumberLabel = "Kontakt broj"
    override val addPartnerButton = "Dodaj"

    /*Settings*/
    override val settingsToolbarTitle = "Postavke"
    override val settingsDarkThemeButton = "Tamna tema"
    override val reselectOrganizationButton = "Odaberi organizaciju"
    override val settingsVatRate = "PDV %"
    override val settingsVatRateError = "Pogrešan PDV format."
    override val settingsLanguage = "Jezik"
}