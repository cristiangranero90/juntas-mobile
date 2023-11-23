package com.juntas.juntas_app.trip_item_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juntas.juntas_app.R

@Composable
fun TripItem(
    usersImages:  List<String>,
    onFavoritesClicked: () -> Unit,
    onShareClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .shadow(10.dp)
            .background(
                color = MaterialTheme.colorScheme.background ,
                shape = RoundedCornerShape(12.dp)
            ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    AsyncImage(
                        model = usersImages?: "empty" ,
                        contentDescription = "Profile image", //TODO: Add her own profile image
                        error = painterResource(id = R.drawable.car_women) ,
                        contentScale = ContentScale.Crop
                    )
                }
                if (usersImages.isNotEmpty()){
                    Text(
                        text = "${usersImages.size} are now on the trip ",
                        style = MaterialTheme.typography.titleSmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                } else {
                    Text(
                        text = "Its totally empty ",
                        style = MaterialTheme.typography.titleSmall,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Box(modifier = Modifier.width(100.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = { onFavoritesClicked() }) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder ,
                                contentDescription = "Add to favorites",
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                        IconButton(onClick = { onShareClicked() }) {
                            Icon(
                                imageVector = Icons.Default.Share ,
                                contentDescription = "Share the trip",
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hurry up!, At least one sit available", //TODO: Trip availability
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TripItemPreview() {
    TripItem(usersImages = emptyList(), {}, {})
}
