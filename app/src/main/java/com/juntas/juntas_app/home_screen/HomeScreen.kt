package com.juntas.juntas_app.home_screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
) {
    val geoPoint = GeoPoint(-38.4192641 , -63.5989206)
    val activity = LocalContext.current as Activity

    BackHandler(true) {
        activity.finish()
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = topBar,
        bottomBar = bottomBar,

    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->

                    MapView(context).apply {
                        // Do anything that needs to happen on the view init here
                        // For example set the tile source or add a click listener
                        setTileSource(TileSourceFactory.USGS_TOPO)
                        setOnClickListener {
                            TODO("Handle click here")
                        }
                    }
                },
                update = { view ->
                    // Code to update or recompose the view goes here
                    // Since geoPoint is read here, the view will recompose whenever it is updated
                    view.controller.setCenter(geoPoint)
                    view.controller.setZoom(6)

                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        topBar = {},
        bottomBar = {}

    )
}
