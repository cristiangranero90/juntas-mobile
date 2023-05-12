package com.juntas.juntas_app.journey_screen.presentation.domain

import com.juntas.juntas_app.BuildConfig
import com.juntas.juntas_app.journey_screen.presentation.data.dto.SpecificRoute
import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi

class RoutesRepositoryImpl(
    private val api: RoutesApi
) : RoutesRepository {
    override suspend fun getSpecificRoute(
        origin: String ,
        destination: String
    ): Result<SpecificRoute> {
        return try {
            Result.success(
                api.getRoute(
                    origin = origin ,
                    destination = destination ,
                    region = "es" ,
                    api_key = BuildConfig.MAPS_API_KEY
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}