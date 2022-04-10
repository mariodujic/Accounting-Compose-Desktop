package com.acc.common.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import com.acc.common.ui.error
import com.acc.common.ui.smallPadding
import com.acc.common.ui.smallerPadding

@Composable
fun AppTextField(
    value: String,
    setValue: (String) -> Unit = {},
    label: String,
    enabled: Boolean = true,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {

    var focused by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(smallerPadding))
        BasicTextField(
            value = value,
            onValueChange = setValue,
            enabled = enabled,
            textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colors.onBackground),
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
        if (errorMessage != null) {
            Text(text = errorMessage, color = error)
        }
    }
}
