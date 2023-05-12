package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MapsOverlay(
    baggageClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val showDialog = remember {
        mutableStateOf(false)
    }
    val showCalendar = remember {
        mutableStateOf(false)
    }
    if (showDialog.value){
        ManyDialog({showDialog.value = false})
    }
    if (showCalendar.value) {
        DatePickerColored(
            onDismiss = { showCalendar.value = false }
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 78.dp),
        verticalArrangement = Arrangement.spacedBy(34.dp),
        horizontalAlignment = Alignment.Start
    ) {
        LargeButtonOverlay(buttonTittle = stringResource(id = R.string.from))

        LargeButtonOverlay(buttonTittle = stringResource(id = R.string.to))

        //Column with the latest three buttons
        Column(
            modifier
                .fillMaxWidth()
                .padding(vertical = 34.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalAlignment = Alignment.Start
        ) {
            MediumButtonsOverlay(
                buttonText = stringResource(R.string.when_string),
                buttonWidth = 148.dp,
                onClick = { showCalendar.value = true })

            MediumButtonsOverlay(
                buttonText = stringResource(R.string.how_many),
                buttonWidth = 177.dp,
                onClick = { showDialog.value = true })

            MediumButtonsOverlay(
                buttonText = stringResource(R.string.baggage),
                buttonWidth = 198.dp,
                onClick = { baggageClicked() })
        }
    }


}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun MapsOverlayPreview(){
    MapsOverlay( {} )
}