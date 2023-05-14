package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun BaggageDialog(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val ready = remember {
        mutableStateOf(false)
    }
    if (ready.value) {
        onDismiss()
    }
    AlertDialog(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        textContentColor = MaterialTheme.colorScheme.onBackground,
        titleContentColor = MaterialTheme.colorScheme.onBackground,
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        ready.value = true
                    },
                    shape = RoundedCornerShape(10.dp) ,
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 2.dp,
                        focusedElevation = 10.dp
                    )
                ) {
                    Text(text = stringResource(id = R.string.accept) , style = MaterialTheme.typography.titleSmall)
                }
            }
        },
        title = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Default.Close
                        , contentDescription = "Dismiss",
                        modifier = Modifier.clickable { onDismiss() }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.baggage) , style = MaterialTheme.typography.headlineLarge)
                }
            }
        },
        text = {
            //Adultas
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                RowItems(type = "Grande")
                RowItems(type = "Mediano")
                RowItems(type = "Chico")
            }
        }
    )
}

@Composable
fun RowItems(
    type: String,
){
    val checkedBox = remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = type)
        Checkbox(checked =  checkedBox.value, onCheckedChange = {checkedBox.value = !checkedBox.value})

    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BaggageDialogPreview() {
    BaggageDialog({})
}