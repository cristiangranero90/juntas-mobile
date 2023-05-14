package com.juntas.juntas_app.journey_screen.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juntas.juntas_app.journey_screen.presentation.data.dto.SpecificRoute
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JourneyViewModel @Inject constructor(
    private val repository: RoutesRepository
) : ViewModel() {

    var state by mutableStateOf(JourneyState())
        private set

    fun getRoute() {
        viewModelScope.launch(Dispatchers.IO) {
            dynamicLoading()
            val aux = repository.getSpecificRoute(state.origin, state.destination)
            if (aux.isSuccess) {
                state = state.copy(
                    response = aux
                        .getOrDefault(SpecificRoute(
                            geocodedWaypoints = emptyList(),
                            routes = emptyList(),
                            "BAD")
                        )
                )
                Log.i("MSG: ", state.response.status)
            } else {
                Log.i("ERROR", "Msg")
            }
            dynamicLoading()
        }
    }
    fun dynamicLoading() {
        state = state.copy(
            isLoading = !state.isLoading
        )
    }

    fun passengerQuntity(quantity: Int ) {
        if (quantity in 0..3) {
            state = state.copy(
                passengers = quantity
            )
        }
    }
    fun childrenQuantity(quantity: Int) {
        if (quantity in 0..3) {
            state = state.copy(
                passengers = quantity
            )
        }
    }
    fun setError(errorStatus: ErrorStatus) {
        state = state.copy(
            error = errorStatus
        )
    }

    fun resetError() {
        state = state.copy(
            error = ErrorStatus.NONE
        )
    }

    fun setOrigin(origin: String) {
        if (origin.isNotBlank()) {
            state = state.copy(
                origin = origin
            )
        } else {
            setError(ErrorStatus.CITIES)
        }
    }

    fun setDestination(destination: String) {
        if (destination.isNotBlank()) {
            state = state.copy(
                destination = destination
            )
        } else {
            setError(ErrorStatus.CITIES)
        }
    }

}