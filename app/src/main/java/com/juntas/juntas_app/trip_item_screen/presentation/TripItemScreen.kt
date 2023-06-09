package com.juntas.juntas_app.trip_item_screen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juntas.juntas_app.R
import com.juntas.juntas_app.trip_item_screen.components.TripItem

@Composable
fun TripItemScreen(
    profileImage: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier ,
) {
    var stars = 3

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { },
        bottomBar = {},
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack  ,
                        contentDescription = "Arrow back",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                item {
                    Row(
                        modifier = Modifier
                            .padding(start = 20.dp , end = 20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier.fillMaxWidth(0.7f)) {
                            Text(
                                text = "Nombre y Apellido",
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(
                                text = "Conduce a tu destino.",
                                style = MaterialTheme.typography.titleMedium,
                            )

                        }

                        Column(
                            modifier
                                .offset(y = 25.dp)
                                .size(100.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                            ) {
                                AsyncImage(
                                    model = profileImage ,
                                    contentDescription = "Profile image",
                                    error = painterResource(id = R.drawable.car_women),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Row(
                                modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                for (i in 0..3) {
                                    if (stars >= 1) {
                                        Icon(
                                            imageVector = Icons.Default.Star ,
                                            contentDescription = "Full star ",
                                            tint = MaterialTheme.colorScheme.secondary
                                        )
                                        stars -= 1
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.StarBorder ,
                                            contentDescription = "Empty star ",
                                            tint = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Sábado 12 de Mayo.",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }

                item {
                    TripItem()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TripItemScreenPreview() {
    TripItemScreen("", {})
}