package com.juntas.juntas_app.journey_screen.presentation

import com.google.android.gms.maps.model.LatLng
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute

data class JourneyState (
    val isLoading: Boolean = false ,
    val departureDate: Long = 0L ,
    val passengers: Int = 0 ,
    val children: Int = 0 ,
    val baggage: MutableList<Boolean> = mutableListOf(false, false, false) ,
    val error: ErrorStatus = ErrorStatus.NONE ,
    val origin: String = "" ,
    val destination: String = "" ,
    val originLatLng: LatLng = LatLng(0.0, 0.0) ,
    val destinationLatLng: LatLng = LatLng(0.0, 0.0) ,
    val responseRoute: SpecificRoute = SpecificRoute(
        geocodedWaypoints = emptyList() ,
        routes = emptyList() ,
        "none") ,
    val responsePlace: List<Prediction> = emptyList()
    )

enum class ErrorStatus{
    DATE,
    SITES,
    BAGGAGE,
    CITIES,
    NONE
}