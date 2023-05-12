package com.juntas.juntas_app.journey_screen.presentation.data.dto


import com.google.gson.annotations.SerializedName

data class OverviewPolyline(
    @SerializedName("points")
    val points: String
)