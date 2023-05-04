package com.juntas.juntas_app.shared_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.compose.AsyncImage
import com.juntas.juntas_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onProfileClicked: () -> Unit,
    onNotificationsClicked: () -> Unit,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Row(modifier = Modifier.fillMaxWidth(),
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
                .clickable { onProfileClicked() }
                .shadow(elevation = 1.dp, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(model = imageUrl,
                    contentDescription = stringResource(R.string.own_profile),
                    contentScale = ContentScale.Fit,
                    error = painterResource(R.drawable.ic_launcher_foreground)
                )
            }
        },
        actions = {
            Image(
                painterResource(id = R.drawable.notification_pink ),
                contentDescription = stringResource(R.string.notifications),
                modifier = Modifier.clickable { onNotificationsClicked() }
            )
        },
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TopBarPreview() {
    TopBar({},{}, "")
}