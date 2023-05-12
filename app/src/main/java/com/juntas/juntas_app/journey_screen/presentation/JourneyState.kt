package com.juntas.juntas_app.journey_screen.presentation

data class JourneyState (
    val isLoading: Boolean = false ,
    val departureDate: String = "" ,
    val passengers: Int = 0 ,
    val children: Int = 0 ,
    val origin: String = "Cordoba",
    val destination: String = "Mendoza",
    )
