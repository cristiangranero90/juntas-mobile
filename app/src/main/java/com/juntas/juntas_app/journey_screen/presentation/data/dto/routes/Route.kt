package com.juntas.juntas_app.journey_screen.presentation.data.dto.routes


import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("bounds")
    val bounds: Bounds ,
    @SerializedName("copyrights")
    val copyrights: String ,
    @SerializedName("legs")
    val legs: List<Leg> ,
    @SerializedName("overview_polyline")
    val overviewPolyline: OverviewPolyline ,
    @SerializedName("summary")
    val summary: String ,
    @SerializedName("warnings")
    val warnings: List<Any> ,
    @SerializedName("waypoint_order")
    val waypointOrder: List<Any>
)