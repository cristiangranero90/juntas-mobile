package com.juntas.juntas_app.trip_screen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar
import com.juntas.juntas_app.trip_screen.presentation.components.TripCard

@Composable
fun TripScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar(
            onProfileClicked = { /*TODO*/ } ,
            onNotificationsClicked = { /*TODO*/ } ,
            imageUrl = ""
        )},
        bottomBar = { BottomBar() }

    ){ paddingValues ->
        //Top info
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.secondary,
                    )
                }
            }
            //Trip items
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                state = rememberLazyListState(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //TODO: See it with Andrea, scroll
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Spacer(modifier = Modifier.width(29.dp))
                        Text(
                            text = stringResource(R.string.better_option) ,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
                items(5) {
                    TripCard(onCardClick = {}, origin = "CABA", destiny = "S.C. Bariloche")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TripScreenPreview() {
    TripScreen()
}