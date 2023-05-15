package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.juntas.juntas_app.R

@Composable
fun LargeButtonOverlay(
    buttonTittle: String ,
    buttonClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedItem = rememberSaveable {
        mutableStateOf("")
    }
    val onClick = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick.value = !onClick.value },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.secondary,
            ),
            elevation = ButtonDefaults
                .buttonElevation(
                    defaultElevation = 8.dp,
                    focusedElevation = 10.dp,
                    pressedElevation = 2.dp
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Site drop menu")
                Text(text = selectedItem.value.ifBlank { buttonTittle })
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop menu realized")
            }
        }
        DropdownMenu(
            expanded = onClick.value,
            onDismissRequest = { onClick.value = false },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(MaterialTheme.colorScheme.background),
            properties = PopupProperties()
        ) {
            DropdownMenuItem(
                text = { Text(text = "Buenos Aires") },
                onClick = {
                    selectedItem.value = "Buenos Aires"
                    buttonClicked(selectedItem.value)
                    onClick.value = false
                          },
            )
            DropdownMenuItem(
                text = { Text(text = "Córdoba") },
                onClick = {
                    selectedItem.value = "Cordoba"
                    onClick.value = false
                          },
            )
        }
    }
}

@Composable
@Preview
fun LargeButtonOverlayPreview() {
    LargeButtonOverlay(stringResource(id = R.string.logo), {})
}