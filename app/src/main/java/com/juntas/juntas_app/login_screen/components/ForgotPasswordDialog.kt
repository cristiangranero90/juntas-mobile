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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.juntas.juntas_app.R

@Composable
fun ForgotPasswordDialog(
    email: (String) -> Unit,
    dismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val emailText = remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismiss() },
        containerColor = MaterialTheme.colorScheme.onPrimary,
        modifier = modifier,
        dismissButton = {
            Button(onClick = { dismiss() }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        confirmButton = {
            Button(onClick = { email(emailText.value) }) {
                Text(text = stringResource(id = R.string.accept))
            }           
        },
        title = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = stringResource(R.string.recover_account))
            }
                },
        text = {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = stringResource(R.string.enter_email))
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
    ForgotPasswordDialog({}, {})
}