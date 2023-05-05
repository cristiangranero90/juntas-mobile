package com.juntas.juntas_app.journey_screen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.juntas.juntas_app.journey_screen.presentation.components.TittleBox
import com.juntas.juntas_app.journey_screen.presentation.components.TittleSearch
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JourneyScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar({/*TODO: Set clicked functions */}, {}, "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg") } ,
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,

        ) {

            item { TittleBox() }
            
            item { TittleSearch() }

            item {

                Box(Modifier.fillMaxSize().height(400.dp)) {
                    val singapore = LatLng(1.35, 103.87)
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(singapore, 10f)
                    }
                    GoogleMap(
                        modifier = Modifier.fillMaxHeight(),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = singapore),
                            title = "Singapore",
                            snippet = "Marker in Singapore"
                        )
                    }
                }
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun JourneyScreenPreview() {
    JourneyScreen()
}
