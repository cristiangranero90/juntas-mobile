package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.juntas.juntas_app.R
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction

@Composable
fun LargeButtonOverlay(
    buttonTittle: String ,
    getSite: (String) -> Unit,
    predictions: List<Prediction>,
    buttonClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedItem = rememberSaveable {
        mutableStateOf("")
    }
    var inputText by remember {
        mutableStateOf("")
    }
    val onClick = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = {
                onClick.value = !onClick.value
                getSite("")
                      },
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
                if (onClick.value) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Site drop menu")
                    OutlinedTextField(
                        value = inputText,
                        onValueChange = {
                            inputText = it
                            getSite(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(45.dp),
                        shape = RoundedCornerShape(10.dp)
                    )
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop menu realized")
                } else {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Site drop menu")
                    Text(text = selectedItem.value.ifBlank { buttonTittle })
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Drop menu realized")
                }
            }
        }
        DropdownMenu(
            expanded = onClick.value,
            onDismissRequest = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(MaterialTheme.colorScheme.background),
            properties = PopupProperties(
                clippingEnabled = false
            )
        ) {
            predictions.forEach { prediction ->
                DropdownMenuItem(
                    text = { Text(text = prediction.description) },
                    onClick = {
                        selectedItem.value = prediction.description
                        buttonClicked(selectedItem.value)
                        onClick.value = false
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowForward ,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                )
                Divider(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
@Preview
fun LargeButtonOverlayPreview() {
    LargeButtonOverlay(stringResource(id = R.string.logo), {},emptyList() ,{})
}