package com.juntas.juntas_app.journey_screen.presentation.data.dto.places


import com.google.gson.annotations.SerializedName

data class StructuredFormatting(
    @SerializedName("main_text")
    val mainText: String ,
    @SerializedName("main_text_matched_substrings")
    val mainTextMatchedSubstrings: List<MainTextMatchedSubstring> ,
    @SerializedName("secondary_text")
    val secondaryText: String?
)