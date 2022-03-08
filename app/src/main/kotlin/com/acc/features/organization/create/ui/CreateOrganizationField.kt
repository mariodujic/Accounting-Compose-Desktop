package com.acc.features.organization.create.ui

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CreateOrganizationField(
    value: String,
    setValue: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = setValue,
        label = { Text(text = label) }
    )
}