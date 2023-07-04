package com.juntas.juntas_app.journey_screen.presentation.data.remote

import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.placesResponseDto
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute
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

    @GET("place/autocomplete/json?")
    suspend fun getSites(
        @Query("input") toSearch: String,
        @Query("language") lang: String,
        @Query("radius") radius: String,
        @Query("type") type: String,
        @Query("key") api_key: String,
        @Query("components") components: String,
    ) : placesResponseDto
}