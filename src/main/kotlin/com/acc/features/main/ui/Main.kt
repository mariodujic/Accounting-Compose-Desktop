package com.acc.features.main.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.acc.common.ui.theme.AppTheme
import com.acc.common.ui.theme.mediumPadding
import com.acc.common.ui.theme.smallPadding

val companies = arrayOf(
    Company(name = "Blue", selected = true),
    Company(name = "Axor", selected = false)
)

data class Company(
    val name: String,
    val selected: Boolean
)

@Composable
@Preview
fun Main() {

    var showCompanies by remember { mutableStateOf(false) }

    AppTheme(useDarkTheme = false) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
            Card(modifier = Modifier.width(200.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(mediumPadding)
                ) {
                    Text(
                        text = companies.first { it.selected }.name,
                        style = MaterialTheme.typography.h2
                    )
                    Spacer(modifier = Modifier.height(smallPadding))
                    Button(onClick = { showCompanies = true }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Switch company")
                    }
                    DropdownMenu(
                        expanded = showCompanies,
                        onDismissRequest = { showCompanies = false },
                        modifier = Modifier.width(200.dp)
                    ) {
                        companies.forEach {
                            DropdownMenuItem(onClick = {
                                showCompanies = false
                            }) {
                                Text(text = it.name)
                            }
                        }
                    }
                }
            }
        }
    }
}
