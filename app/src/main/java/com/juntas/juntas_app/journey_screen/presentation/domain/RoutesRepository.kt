package com.juntas.juntas_app.journey_screen.presentation.domain

import com.juntas.juntas_app.journey_screen.presentation.data.dto.SpecificRoute
import dagger.Provides


interface RoutesRepository {

    @Provides
    suspend fun getSpecificRoute(origin: String, destination: String) : Result<SpecificRoute>

}