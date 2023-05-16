package com.juntas.juntas_app.journey_screen.presentation.data.dto.routes


import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("distance")
    val distance: Distance ,
    @SerializedName("duration")
    val duration: String ,
    @SerializedName("end_location")
    val endLocation: String ,
    @SerializedName("html_instructions")
    val htmlInstructions: String ,
    @SerializedName("maneuver")
    val maneuver: String? ,
    @SerializedName("polyline")
    val polyline: Polyline ,
    @SerializedName("start_location")
    val startLocation: String ,
    @SerializedName("travel_mode")
    val travelMode: String
)