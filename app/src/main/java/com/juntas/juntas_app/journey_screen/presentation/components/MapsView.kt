package com.juntas.juntas_app.journey_screen.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.juntas.juntas_app.R
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MapsView(
    onContinueClicked: () -> Unit ,
    specificRoute: SpecificRoute,
    passenger: Int ,
    children: Int ,
    getSite: (String) -> Unit,
    setOriginId: (String) -> Unit,
    setDestinationId: (String) -> Unit,
    predictions: List<Prediction>,
    toPreferenceContext: Boolean ,
    onMinusChildren: () -> Unit ,
    onPlusChildren: () -> Unit ,
    onMinusPassenger: () -> Unit ,
    onPlusPassenger: () -> Unit ,
    modifier: Modifier = Modifier
) {
    val modifierHeight: Modifier =
        if (!toPreferenceContext) Modifier.height(500.dp) else Modifier.height(800.dp)
    val argentina = LatLng(-38.4192641 , -63.5989206)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(argentina , 4f)
    }
    val routes: MutableList<LatLng> = remember { mutableListOf() }
    var originState = remember {
        LatLng(0.0 , 0.0)
    }
    var destinationState = remember {
        LatLng(0.0 , 0.0)
    }
    //Poly-lines
    if (specificRoute.routes.isNotEmpty()) {
        specificRoute.routes.forEach { route ->
            route.legs.forEach { leg ->
                originState = LatLng(leg.startLocation.lat , leg.startLocation.lng)
                destinationState = LatLng(leg.endLocation.lat , leg.endLocation.lng)
                leg.steps.forEach { step ->
                    routes.add(LatLng(step.startLocation.lat , step.startLocation.lng))
                    routes.add(LatLng(step.endLocation.lat , step.endLocation.lng))
                }
            }
        }
        //Camera position animation to destination
        LaunchedEffect(key1 = destinationState ) {
            cameraPositionState.animate(
                update = CameraUpdateFactory.newCameraPosition(
                    CameraPosition.fromLatLngZoom(destinationState, 7f)
                ),
                durationMs = 3000
            )
        }
    }
    Box(modifier = modifierHeight) {
        if (!toPreferenceContext) {
            GoogleMap(
                modifier = Modifier.fillMaxSize() ,
                properties = MapProperties(mapType = MapType.NORMAL) ,
                cameraPositionState = cameraPositionState ,
            ) {
                if (routes.isNotEmpty()) {
                    Polyline(points = routes, color = MaterialTheme.colorScheme.primary)
                    Marker( state = MarkerState(originState))
                    Marker( state = MarkerState(destinationState))
                }
            }
        }
        //Context animation
        AnimatedVisibility(
            visible = toPreferenceContext ,
            enter = slideInHorizontally(animationSpec = tween(2000, 30)) ,
            //exit = fadeOut() + slideOutVertically(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_women) ,
                contentDescription = "Main image" ,
                modifier = Modifier.fillMaxSize() ,
                contentScale = ContentScale.FillHeight ,
                alignment = Alignment.Center
            )
        }
        //Maps buttons and personal information
        MapsOverlay(
            onContinueClicked = { onContinueClicked() } ,
            passenger = passenger ,
            children = children ,
            onMinusChildren = { onMinusChildren() } ,
            onPlusChildren = { onPlusChildren() } ,
            onMinusPassenger = { onMinusPassenger() } ,
            onPlusPassenger = { onPlusPassenger() } ,
            toPreferenceContext = toPreferenceContext ,
            predictions = predictions ,
            getSite = { getSite(it) } ,
            setOriginId = { setOriginId(it) } ,
            setDestinationId = { setDestinationId(it) }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun MapsViewPreview() {
    //MapsView({},0,0, {},{},{},emptyList() ,false,{},{},{},{})
}