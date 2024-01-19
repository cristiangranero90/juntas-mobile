package com.juntas.juntas_app.login_screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.juntas.juntas_app.R
import com.juntas.juntas_app.login_screen.components.ForgotPasswordDialog
import com.juntas.juntas_app.login_screen.domain.LoginError

@Composable
fun LoginScreen(
    loginOk: () -> Unit,
    modifier: Modifier = Modifier,
    vm: LoginScreenViewModel = hiltViewModel()
) {

    val data = vm.state
    val context = LocalContext.current

    if(data.isLogin) {
        loginOk()
    }
    if (data.error == LoginError.CREDENTIALS) {
        Toast.makeText(context, "Error de credenciales, por favor inténtelo nuevamente mas tarde", Toast.LENGTH_SHORT).show()
        vm.resetError()
    }

    if (data.error == LoginError.EMPTY) {
        Toast.makeText(context, "Tenes que escribir el email y la contraseña", Toast.LENGTH_SHORT).show()
        vm.resetError()
    }
    if (data.error == LoginError.FORGOT){
        ForgotPasswordDialog(email = { vm.forgotPass(it) } )
    }
    if (data.error == LoginError.EMAIL) {
        Toast.makeText(context, "No existe cuenta con ese email", Toast.LENGTH_SHORT).show()
        vm.resetError()
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painterResource(id = R.drawable.logo_juntas) , contentDescription = "Juntas Logo")
        }
        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            value = data.email,
            onValueChange = {vm.changeEmail(it)},
            singleLine = true,
            maxLines = 1,
            placeholder = { Text(text = "Email")}

        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = data.password,
            onValueChange = { vm.changePass(it)},
            singleLine = true,
            maxLines = 1,
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text(text = stringResource(R.string.password))}

        )
        Text(
            text = "No recuerdo mi contraseña",
            modifier = Modifier.clickable {
                vm.recoveryPass()
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(10.dp),
            onClick = { vm.verify() }
        ) {
            Text(text = stringResource(R.string.login))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    painterResource(id = R.drawable.google_icon),
                    contentDescription = "Google Button",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    painterResource(id = R.drawable.facebook_icon),
                    contentDescription = "Facebook Button",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Unspecified
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(text = stringResource(R.string.not_account))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.signup))
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({})
}