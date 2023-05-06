package com.juntas.juntas_app.journey_screen.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.rememberCameraPositionState
import com.juntas.juntas_app.R

@Composable
fun MapsView(
    modifier: Modifier = Modifier
) {

    Box(modifier = modifier.height(500.dp)) {
        val argentina = LatLng(-38.4192641, -63.5989206)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(argentina, 4f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = MapProperties(mapType = MapType.NORMAL),
            cameraPositionState = cameraPositionState,

            )
        //
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 78.dp),
            verticalArrangement = Arrangement.spacedBy(34.dp),
            horizontalAlignment = Alignment.Start
        ) {
            LargeButtonOverlay(buttonTittle = stringResource(id = R.string.from))

            LargeButtonOverlay(buttonTittle = stringResource(id = R.string.to))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MapsViewPreview() {
    MapsView()
}