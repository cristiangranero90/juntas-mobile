package com.juntas.juntas_app.trip_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AirlineSeatReclineNormal
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.juntas.juntas_app.R
import java.time.LocalDate
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripCard(
    onCardClick: () -> Unit ,
    origin: String ,
    destiny: String ,
    name: String ,
    profileImage: String ,
    qualification: Int ,
    date: LocalDate,
    time: LocalTime,
    passengers: Int,
    modifier: Modifier = Modifier
) {
    var stars = qualification
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            onClick = { onCardClick() },
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
                       .padding(top = 50.dp , start = 10.dp , end = 30.dp),
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
                    //Driver Profile
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
                                .shadow(2.dp , shape = CircleShape),
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
                    //Stars & qualification
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
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
                    //Drive name section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = stringResource(R.string.driven_by) ,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = name,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    //Date, time, passengers
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.calendar_icon),
                            contentDescription = "Calendar",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = date.toString(), style = MaterialTheme.typography.bodySmall)
                    }
                    //Show trip time
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Schedule,
                            contentDescription = "Time",
                            tint = MaterialTheme.colorScheme.tertiary,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = time.toString(), style = MaterialTheme.typography.bodySmall)
                    }
                    //Passengers
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AirlineSeatReclineNormal,
                            contentDescription = "Passengers",
                            tint = MaterialTheme.colorScheme.tertiary,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "$passengers ${stringResource(id = R.string.passenger)}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    //See more button at the bottom of the frame
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().offset(x = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = modifier
                                .size(20.dp)
                                .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.forward_arrow_icon) ,
                                contentDescription = "See more",
                                tint = Color.White,
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun TripCardPreview() {
    TripCard(
        {},
        "CABA",
        "S.C Bariloche",
        "Some name",
        "",
        3,
        LocalDate.now(),
        LocalTime.now(),
        passengers = 2
    )
}