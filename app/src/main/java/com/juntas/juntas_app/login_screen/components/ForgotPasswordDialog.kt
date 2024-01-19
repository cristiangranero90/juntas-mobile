package com.juntas.juntas_app.login_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ForgotPasswordDialog(
    email: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val emailText = remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        containerColor = MaterialTheme.colorScheme.onPrimary,
        confirmButton = {
            Button(onClick = { email(emailText.value) }) {
                Text(text = "Aceptar")
            }           
        },
        title = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = "Recuperar cuenta")
            }
                },
        text = {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Ingresá tu email")
                OutlinedTextField(
                    value = emailText.value,
                    onValueChange = { emailText.value = it },
                )
            }
        }
    )
}


@Preview
@Composable
fun ForgotPasswordDialogPreview() {
    ForgotPasswordDialog({})
}