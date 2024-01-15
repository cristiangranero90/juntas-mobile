package com.juntas.juntas_app.journey_create_first.domain

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JourneyCreate(
    topBar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    modifier: Modifier = Modifier,
){




}


@Composable
@Preview
fun JourneyCreatePreview(){
    JourneyCreate( {},{} )
}