package com.juntas.juntas_app.journey_create_first.domain

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@Composable
fun JourneyCreate(
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    modifier: Modifier = Modifier,
){
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = topBar,
        bottomBar = bottomBar
    ) {paddingValues ->

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            Text(text = "Driver screen")
        }

    }



}


@Composable
@Preview
fun JourneyCreatePreview(){
    JourneyCreate( topBar = {
        TopBar(
        onCloseSession = { /*TODO*/ },
        onNotificationsClicked = { /*TODO*/ },
        imageUrl = ""
    )
    },
        bottomBar = {
            BottomBar(
                currentDestination = null,
                onHomeClicked = { /*TODO*/ },
                onPassengerClicked = { /*TODO*/ },
                onDriverClicked = { /*TODO*/ })
        }
    )
}