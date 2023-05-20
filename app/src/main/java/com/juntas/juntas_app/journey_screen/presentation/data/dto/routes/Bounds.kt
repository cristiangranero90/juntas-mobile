package com.juntas.juntas_app.journey_screen.presentation.data.dto.routes


import com.google.gson.annotations.SerializedName

data class Bounds(
    @SerializedName("northeast")
    val northeast: Northeast ,
    @SerializedName("southwest")
    val southwest: Southwest
)