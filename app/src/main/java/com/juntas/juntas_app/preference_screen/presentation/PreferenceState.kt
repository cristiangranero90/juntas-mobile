package com.juntas.juntas_app.preference_screen.presentation

data class PreferenceState(
    val smokers: Boolean = false ,
    val petfriendly: Boolean = false ,
    val children: Boolean = false ,
    val allergy: Boolean = false ,
    val chainWheel: Boolean = false ,
    val medication: Boolean = false ,
    val allergyText: String = "" ,
    val chainWheelText: String = "" ,
    val medicationText: String = "" ,
    val otherInfo: String = ""
)
