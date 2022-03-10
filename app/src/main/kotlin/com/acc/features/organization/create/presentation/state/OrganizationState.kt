package com.acc.features.organization.create.presentation.state

import androidx.compose.runtime.*

@Composable
fun rememberOrganizationState(): CreateOrganizationState {
    return remember { CreateOrganizationState() }
}

class CreateOrganizationState {

    var organizationId by mutableStateOf("")
    var name by mutableStateOf("")
    var postCode by mutableStateOf("")
    var address by mutableStateOf("")

    val valid by derivedStateOf {
        organizationId.isNotEmpty() && name.isNotEmpty() && postCode.isNotEmpty() && address.isNotEmpty()
    }
}