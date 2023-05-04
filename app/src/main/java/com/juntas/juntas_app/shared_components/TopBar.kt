package com.juntas.juntas_app.shared_components

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.juntas.juntas_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
                Image(painterResource(id = R.drawable.logo_juntas_pink), contentDescription = "Logo")
        },
        navigationIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profile action")
                         },
        actions = {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications")
        },

    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TopBarPreview() {
    TopBar()
}