package com.juntas.juntas_app.journey_screen.presentation.data.dto.routes


import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("distance")
    val distance: Distance ,
    @SerializedName("duration")
    val duration: TextValueObject ,
    @SerializedName("polyline")
    val polyline: Polyline ,
    @SerializedName("start_location")
    val startLocation: StartLocation ,
    @SerializedName("end_location")
    val endLocation: EndLocation
)
data class TextValueObject(
    val text: String,
    val value: Integer,
)