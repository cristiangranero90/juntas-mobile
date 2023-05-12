package com.juntas.juntas_app.journey_screen.presentation

import com.juntas.juntas_app.journey_screen.presentation.data.dto.SpecificRoute

data class JourneyState (
    val isLoading: Boolean = false ,
    val departureDate: String = "" ,
    val passengers: Int = 0 ,
    val children: Int = 0 ,
    val baggage: BaggageStatus = BaggageStatus.NONE ,
    val error: ErrorStatus = ErrorStatus.NONE,
    val origin: String = "" ,
    val destination: String = "" ,
    val response: SpecificRoute = SpecificRoute(
        geocodedWaypoints = emptyList() ,
        routes = emptyList() ,
        "none") ,
    )

enum class BaggageStatus {
    NONE,
    MEDIUM,
    SMALL,
    BIG
}
enum class ErrorStatus{
    DATE,
    SITES,
    BAGGAGE,
    CITIES,
    NONE
}