package com.juntas.juntas_app.trip_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@Composable
fun TopCard(
    onFavouritesClicked: () -> Unit,
    onShareClicked: () -> Unit,
    spaceQuantity: Int,
    modifier: Modifier = Modifier
) {
    val spaceSize = when {
        spaceQuantity == 0 -> 1f
        spaceQuantity == 1 -> 0.8f
        spaceQuantity == 2 -> 0.6f
        spaceQuantity == 3 -> 0.4f
        else -> 0.1f
    }
    val color = when {
        spaceQuantity == 0 -> Color.Red
        spaceQuantity in 1..2 -> Color.Yellow
        else -> Color.Green
    }
    val spaceText = when {
        spaceQuantity == 0 -> stringResource(R.string.full)
        spaceQuantity == 1 -> stringResource(R.string.last_seat)
        spaceQuantity == 2 -> stringResource(R.string.half_seats)
        else -> stringResource(R.string.empty_seats)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Box(
            modifier
                .offset(y = (-20).dp)
                .background(Color.LightGray , shape = RoundedCornerShape(10.dp))
                .width(160.dp)
                .height(39.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(spaceSize)
                    .background(color, shape = RoundedCornerShape(10.dp))
            )
            Text(text = spaceText)
        }
        Row(
            modifier = Modifier
        ) {
            IconButton(onClick = { onFavouritesClicked() }) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder ,
                    contentDescription = "Add to favourites",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(onClick = { onShareClicked() }) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = "Share with your friends",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}