package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.juntas.juntas_app.R
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MapsView(
    onContinueClicked: () -> Unit ,
    passenger: Int ,
    children: Int ,
    getSite: (String) -> Unit,
    predictions: List<Prediction>,
    toPreferenceContext: Boolean ,
    onMinusChildren: () -> Unit ,
    onPlusChildren: () -> Unit ,
    onMinusPassenger: () -> Unit ,
    onPlusPassenger: () -> Unit ,
    modifier: Modifier = Modifier
) {
    val argentina = LatLng(-38.4192641, -63.5989206)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(argentina, 4f)
    }
    val markerState = rememberMarkerState(
        position = argentina
    )
    val modifierHeight: Modifier = if (!toPreferenceContext) Modifier.height(500.dp) else Modifier.height(800.dp)


    Box(modifier = modifierHeight) {
        if (!toPreferenceContext) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                properties = MapProperties(mapType = MapType.NORMAL),
                cameraPositionState = cameraPositionState,
            ) {
                //Marker(
                //    state = markerState,

                //)
            }
        }
        AnimatedVisibility(
            visible = toPreferenceContext,
            enter = fadeIn() + slideInVertically() ,
            exit = fadeOut() + slideOutVertically()
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_women),
                contentDescription = "Main image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.Center
            )
        }
        //
        MapsOverlay(
            onContinueClicked = { onContinueClicked() },
            passenger = passenger,
            children = children,
            onMinusChildren = {onMinusChildren()},
            onPlusChildren = {onPlusChildren()},
            onMinusPassenger = {onMinusPassenger()},
            onPlusPassenger = {onPlusPassenger()},
            toPreferenceContext = toPreferenceContext,
            predictions = predictions,
            getSite = { getSite(it)}
        )
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun MapsViewPreview() {
    MapsView({},0,0, {},emptyList() ,false,{},{},{},{})
}