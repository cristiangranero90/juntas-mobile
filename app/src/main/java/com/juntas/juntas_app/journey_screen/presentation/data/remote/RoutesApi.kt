package com.juntas.juntas_app.journey_screen.presentation.data.remote

import com.juntas.juntas_app.journey_screen.presentation.data.dto.SpecificRoute
import retrofit2.http.GET
import retrofit2.http.Query

interface RoutesApi {
    companion object {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/"
    }

    @GET("directions/json?")
    suspend fun getRoute(
        @Query("origin") origin: String,
        @Query("destination")destination: String,
        @Query("region") region: String,
        @Query("key") api_key: String) : SpecificRoute
}