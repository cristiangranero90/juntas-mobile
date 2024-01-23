package com.juntas.juntas_app.shared_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juntas.juntas_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onProfileClicked: () -> Unit,
    onNotificationsClicked: () -> Unit,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    
    var open = remember {
        mutableStateOf(false)
    }
    var elements = remember {
        mutableStateListOf<String>()
    }
    elements.add("Close session")
    
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Row(modifier = Modifier
                .fillMaxWidth()
                .absoluteOffset(x = (-20).dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.size(width = 132.dp, height = 64.dp),
                    contentAlignment = Alignment.TopCenter,
                ) {
                    Image(painterResource(
                        id = R.drawable.logo_juntas_white),
                        contentDescription = stringResource(R.string.logo),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        },

        navigationIcon = {
            Box(modifier = Modifier
                .size(39.dp)
                .clip(CircleShape)
                .clickable {
                    onProfileClicked()
                    open.value = !open.value
                }
                .shadow(elevation = 1.dp, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(model = imageUrl,
                    contentDescription = stringResource(R.string.own_profile),
                    contentScale = ContentScale.Fit,
                    error = painterResource(R.drawable.ic_launcher_foreground)
                )
                DropdownMenu(
                    expanded = open.value,
                    onDismissRequest = { open.value = !open.value }
                ) {
                    for (element: String in elements) {
                        Text(
                            text = element,
                            modifier = Modifier.clickable {
                                open.value = !open.value
                                Firebase.auth.signOut()
                                //TODO: Repair SignOut
                            }
                        )
                    }
                }
            }
        },
        actions = {
            Image(
                painterResource(id = R.drawable.notification_pink ),
                contentDescription = stringResource(R.string.notifications),
                modifier = Modifier
                    .clickable { onNotificationsClicked() }
            )
        },
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TopBarPreview() {
    TopBar({},{}, "")
}