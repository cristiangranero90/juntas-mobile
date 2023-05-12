package com.juntas.juntas_app.journey_screen.presentation.data.dto


import com.google.gson.annotations.SerializedName

data class SpecificRoute(
    @SerializedName("geocoded_waypoints")
    val geocodedWaypoints: List<GeocodedWaypoint> ,
    @SerializedName("routes")
    val routes: List<Route> ,
    @SerializedName("status")
    val status: String
)