package com.juntas.juntas_app.trip_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juntas.juntas_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripCard(
    onCardClick: (Int) -> Unit,
    origin: String,
    destiny: String,
    profileImage: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = modifier
                .height(328.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
                pressedElevation = 2.dp,
                focusedElevation = 12.dp
            ),
            ) {
                Column(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 50.dp , start = 10.dp, end = 30.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    //First circle, origin
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = "Origin, Start",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = origin,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    //Vertical divider, 2.dp
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(horizontal = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .background(color = Color.Gray)
                                .width(2.dp),
                        )
                    }
                    //Second circle, destiny
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Circle,
                            contentDescription = "Origin, Start",
                            tint = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = destiny,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(35.dp)
                                .shadow(2.dp, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = profileImage ,
                                contentDescription = "Driver profile",
                                error = painterResource(id = R.drawable.car_women),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                }
            }
        //Top card information
        Column(
            modifier = Modifier
                .fillMaxWidth() ,
        ) {
            TopCard(
                onFavouritesClicked = { /*TODO*/ } ,
                onShareClicked = { /*TODO*/ } ,
                spaceQuantity = 3
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TripCardPreview() {
    TripCard({}, "CABA","S.C Bariloche", "")
}