package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MapsView(
    baggageClicked: () -> Unit,
    passenger: Int,
    children: Int,
    onMinusChildren: () -> Unit,
    onPlusChildren: () -> Unit,
    onMinusPassenger: () -> Unit,
    onPlusPassenger: () -> Unit,
    modifier: Modifier = Modifier
) {
    val argentina = LatLng(-38.4192641, -63.5989206)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(argentina, 4f)
    }
    val markerState = rememberMarkerState(
        position = argentina
    )


    Box(modifier = modifier.height(500.dp)) {

       GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = MapProperties(mapType = MapType.NORMAL),
            cameraPositionState = cameraPositionState,
       ) {
           Marker(
               state = markerState,

           )
       }

        //
        MapsOverlay(
            baggageClicked = { baggageClicked() },
            passenger = passenger,
            children = children,
            onMinusChildren = {onMinusChildren()},
            onPlusChildren = {onPlusChildren()},
            onMinusPassenger = {onMinusPassenger()},
            onPlusPassenger = {onPlusPassenger()}
        )
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun MapsViewPreview() {
    MapsView({},0,0,{},{},{},{})
}