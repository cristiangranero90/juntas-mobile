package com.juntas.juntas_app.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    val geoPoint = GeoPoint(0.0, 0.0)


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
                        setTileSource(TileSourceFactory.WIKIMEDIA)
                        setOnClickListener {
                            TODO("Handle click here")
                        }
                    }
                },
                update = { view ->
                    // Code to update or recompose the view goes here
                    // Since geoPoint is read here, the view will recompose whenever it is updated
                    view.controller.setCenter(geoPoint)
                    view.controller.setZoom(9.5)

                },
            )
        }
    }
}

