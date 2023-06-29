package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juntas.juntas_app.R
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MapsOverlay(
    onContinueClicked: () -> Unit ,
    passenger: Int ,
    children: Int ,
    getSite: (String) -> Unit ,
    setOriginId: (String) -> Unit ,
    setDestinationId: (String) -> Unit ,
    predictions: List<Prediction> ,
    toPreferenceContext: Boolean ,
    onMinusChildren: () -> Unit ,
    onPlusChildren: () -> Unit ,
    onMinusPassenger: () -> Unit ,
    onPlusPassenger: () -> Unit ,
    modifier: Modifier = Modifier
){
    val origin = remember {
        mutableStateOf("")
    }
    val destination = remember {
        mutableStateOf("")
    }
    val showDialog = remember {
        mutableStateOf(false)
    }
    val showCalendar = remember {
        mutableStateOf(false)
    }
    val showBaggage = remember {
        mutableStateOf(false)
    }
    val manyQuantity = remember {
        mutableStateOf("")
    }
    val dateCalendar = remember {
        mutableStateOf(0L)
    }
    val baggageReady = remember {
        mutableStateOf(false)
    }
    val baggageItems = remember {
        mutableStateListOf(false, false, false)
    }
    val calendar = remember { Calendar.getInstance() }

    if (showBaggage.value) {
        BaggageDialog(
            onDismiss = { showBaggage.value = false },
            onReady = {
                baggageReady.value = true
                showBaggage.value = false
                      },
            baggageItems = baggageItems,
            onBaggageClicked = { index -> baggageItems[index] = !baggageItems[index]}
        )
    }
    if (showDialog.value){
        ManyDialog(
            onDismiss = { showDialog.value = false },
            onReady = {
                manyQuantity.value = passenger.toString()
                showDialog.value = false
            },
            passenger = passenger,
            children = children,
            onMinusChildren = { onMinusChildren() },
            onPlusChildren = { onPlusChildren() },
            onMinusPassenger = { onMinusPassenger() },
            onPlusPassenger = { onPlusPassenger() }
        )
    }
    if (showCalendar.value) {
        DatePickerColored(
            onClose = {
                dateCalendar.value = it
                calendar.timeInMillis = it
                showCalendar.value = false
                      },
            onDismiss = { showCalendar.value = false }
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp , end = 20.dp , top = if (!toPreferenceContext) 78.dp else 20.dp),
        verticalArrangement = Arrangement.spacedBy(34.dp),
        horizontalAlignment = Alignment.Start
    ) {
        //Text on preference
        if (toPreferenceContext) {
            Row(
                modifier = Modifier.fillMaxWidth() ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(R.string.great) ,
                    style = MaterialTheme.typography.headlineLarge ,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth() ,
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.check_the_information_data) ,
                    style = MaterialTheme.typography.titleLarge ,
                    color = Color.White
                )
            }
        }
        LargeButtonOverlay(
            buttonTittle = origin.value.ifBlank { stringResource(id = R.string.from) },
            buttonClicked = { origin.value = it },
            predictions = predictions,
            getSite = { getSite(it) },
            setId = { setOriginId(it) }
        )
        LargeButtonOverlay(
            buttonTittle = destination.value.ifBlank { stringResource(id = R.string.to) },
            buttonClicked = { destination.value = it },
            predictions = predictions,
            getSite = { getSite(it) },
            setId = { setDestinationId(it) }
        )

        //Column with the latest three buttons
        Column(
            modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalAlignment = Alignment.Start
        ) {

            MediumButtonsOverlay(
                complete = dateCalendar.value != 0L,
                icon = Icons.Default.EditCalendar,
                buttonText = if (dateCalendar.value == 0L) stringResource(R.string.when_string)
                    else (calendar.get(Calendar.DATE) + 1).toString() + "/"
                        + ((calendar.get(Calendar.MONTH)) + 1).toString() + "/"
                        + calendar.get(Calendar.YEAR).toString() ,
                buttonWidth = 148.dp,
                onClick = { showCalendar.value = true })

            MediumButtonsOverlay(
                complete = manyQuantity.value.isNotBlank(),
                icon = Icons.Default.Group,
                buttonText = if(manyQuantity.value.isBlank()) stringResource(id = R.string.how_many)
                    else manyQuantity.value + " " +
                        stringResource(id = R.string.adult),
                buttonWidth = 177.dp,
                onClick = { showDialog.value = true })

            MediumButtonsOverlay(
                complete = baggageReady.value,
                icon = Icons.Default.Luggage,
                buttonText = if (baggageReady.value) stringResource(R.string.already_selected)
                    else stringResource(R.string.baggage),
                buttonWidth = 198.dp,
                onClick = { showBaggage.value = true })

            //Text to preference context
            AnimatedVisibility(
                visible = toPreferenceContext,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.one_more_step),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.White
                    )
                }
            }
            //Continue button
            AnimatedVisibility(
                visible = dateCalendar.value != 0L
                        && manyQuantity.value.isNotBlank()
                        && baggageReady.value
                        && origin.value.isNotBlank()
                        && destination.value.isNotBlank(),
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = { onContinueClicked() },
                            shape = RoundedCornerShape(10.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 10.dp,
                                pressedElevation = 2.dp,
                                focusedElevation = 10.dp
                            )
                        ) {
                            Text(
                                text = if (!toPreferenceContext) stringResource(R.string.continue_button)
                                    else stringResource(R.string.choose_your_preferences) ,
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    }
                }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun MapsOverlayPreview(){
    MapsOverlay( onContinueClicked = {}, 0,0, {},{},{},emptyList() ,false,{},{},{},{} )
}