package com.juntas.juntas_app.journey_screen.presentation

import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute
import kotlinx.coroutines.flow.Flow

data class JourneyState (
    val isLoading: Boolean = false ,
    val departureDate: Long = 0L,
    val passengers: Int = 0 ,
    val children: Int = 0 ,
    val baggage: BaggageStatus = BaggageStatus.NONE ,
    val error: ErrorStatus = ErrorStatus.NONE,
    val origin: String = "" ,
    val destination: String = "" ,
    val responseRoute: SpecificRoute = SpecificRoute(
        geocodedWaypoints = emptyList() ,
        routes = emptyList() ,
        "none"),
    val responsePlace: List<Prediction> = emptyList()
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