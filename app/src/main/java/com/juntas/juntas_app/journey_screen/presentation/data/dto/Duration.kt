package com.juntas.juntas_app.journey_screen.presentation.data.dto


import com.google.gson.annotations.SerializedName

data class Duration(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)