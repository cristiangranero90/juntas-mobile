package com.juntas.juntas_app.login_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R
import com.juntas.juntas_app.login_screen.domain.UserRegister

@Composable
fun RegisterDialog(
    onDismiss: () -> Unit,
    onAccept: (UserRegister) -> Unit,
    modifier: Modifier = Modifier
) {
    val name = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val visibility = remember {
        mutableStateOf(false)
    }

    AlertDialog(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.onPrimary,
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            Button(
                onClick = {
                    val user = UserRegister(
                        name = name.value,
                        lastName = lastName.value,
                        email = email.value,
                        password = password.value
                    )
                    onAccept(user)
                    },
                enabled = name.value.isNotBlank() &&
                        lastName.value.isNotBlank() &&
                        email.value.isNotBlank() &&
                        password.value.isNotBlank()
            ) {
                Text(text = stringResource(id = R.string.accept))
            }
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.create_account))
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        text = {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = stringResource(R.string.your_name) + ":")
                OutlinedTextField(
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.your_last_name)+ ":")
                OutlinedTextField(
                    value = lastName.value,
                    onValueChange = {
                        lastName.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.enter_email) + ":")
                OutlinedTextField(
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = stringResource(id = R.string.enter_password) + ":")
                OutlinedTextField(
                    value = password.value,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        password.value = it
                    },
                    trailingIcon = {
                        IconButton(onClick = { visibility.value = !visibility.value }) {
                            Icon(
                                if (!visibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = "Visual transformation"
                            )
                        }
                    },
                    visualTransformation = if(!visibility.value) PasswordVisualTransformation() else VisualTransformation.None
                )
            }
        },
    )
}



@Composable
@Preview
fun RegisterDialogPreview(
    modifier: Modifier = Modifier
) {
    RegisterDialog(onDismiss = { /*TODO*/ }, onAccept = {})
}

