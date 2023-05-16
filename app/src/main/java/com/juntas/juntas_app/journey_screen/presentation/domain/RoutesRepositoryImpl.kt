package com.juntas.juntas_app.journey_screen.presentation.domain

import androidx.compose.ui.platform.LocalContext
import com.juntas.juntas_app.BuildConfig
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.placesResponseDto
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute
import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi
import java.util.Locale

class RoutesRepositoryImpl(
    private val api: RoutesApi
) : RoutesRepository {

    private val lang = Locale.getDefault().toString()
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
                    api_key = BuildConfig.DIRECTIONS_API
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    override suspend fun getPlaces(toSearch: String): Result<placesResponseDto> {
        return try {
            Result.success(
                api.getSites(
                    toSearch = toSearch,
                    lang = lang,
                    radius = "500",
                    type = "geocode",
                    api_key = BuildConfig.DIRECTIONS_API
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}