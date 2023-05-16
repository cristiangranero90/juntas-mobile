package com.juntas.juntas_app.journey_screen.presentation.data.dto.places


import com.google.gson.annotations.SerializedName

data class placesResponseDto(
    @SerializedName("predictions")
    val predictions: List<Prediction>,
    @SerializedName("status")
    val status: String
)