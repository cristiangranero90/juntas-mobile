package com.juntas.juntas_app.trip_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripCard(
    onCardClick: (Int) -> Unit ,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier
            .height(328.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 2.dp,
            focusedElevation = 12.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
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
    TripCard({})
}