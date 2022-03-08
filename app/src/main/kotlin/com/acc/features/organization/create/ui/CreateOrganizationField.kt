package com.acc.features.organization.create.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import com.acc.common.ui.smallPadding
import com.acc.common.ui.smallerPadding

@Composable
fun CreateOrganizationField(
    value: String,
    setValue: (String) -> Unit,
    label: String
) {

    var focused by remember { mutableStateOf(false) }

    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.typography.subtitle1.color.copy(alpha = 0.4f)
        )
        Spacer(modifier = Modifier.height(smallerPadding))
        BasicTextField(
            value = value,
            onValueChange = setValue,
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (focused) 1.25.dp else 1.dp,
                    color = if (focused) {
                        MaterialTheme.colors.primary.copy(alpha = 0.7f)
                    } else {
                        MaterialTheme.colors.background
                    },
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(smallPadding)
                .onFocusChanged {
                    focused = it.isFocused
                }
        )
    }
}
