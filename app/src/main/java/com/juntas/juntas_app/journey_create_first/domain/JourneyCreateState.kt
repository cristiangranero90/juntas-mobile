package com.juntas.juntas_app.journey_create_first.domain

import java.time.ZonedDateTime

data class JourneyCreateState(
    val site: Site,
    val dateTime: ZonedDateTime,
    val vehicle: Vehicle,
    val documentation: Documentation,
    val baggage: Baggage,
    val contextOverlay: List<Int>,
    val loading: Boolean,
    val additional: String
)

data class Site(
    val id: Long,
    val province: String,
    val data: String
)

data class Vehicle(
    val patent: String,
    val brand: String,
    val model: String,
    val color: String
)

data class Documentation(
    val doc1: String,
    val doc2: String
)

data class Baggage(
    val small: Int,
    val medium: Int,
    val big: Int
)
