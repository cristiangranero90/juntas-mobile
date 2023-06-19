package com.juntas.juntas_app.journey_screen.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    init {
        //getSites("argentina")
    }
    private fun getRoute() {
        if (state.destinationId.isNotBlank() && state.originId.isNotBlank()) {
            viewModelScope.launch(Dispatchers.IO) {
                dynamicLoading()
                repository.getSpecificRoute(state.originId, state.destinationId).onSuccess { route ->
                    state = state.copy(
                        responseRoute = route
                    )
                }.onFailure {
                    setError(ErrorStatus.CITIES)
                }
                dynamicLoading()
            }
        }
    }
    fun setDeparture(date: Long) {
        if (date != 0L) {
            state = state.copy(
                departureDate = date
            )
        } else {
            setError(ErrorStatus.DATE)
        }
    }
    fun setOriginId(id: String) {
        Log.i("ID: ", "Origin: $id")
        state = state.copy(
            originId = id
        )
        getRoute()
    }
    fun setDestinationId(id: String) {
        Log.i("ID: ", "Destination: $id")
        state = state.copy(
            destinationId = id
        )
        getRoute()
    }
    fun changeBaggage(position: Int) {
        if (position in 0..2) {
            state.baggage[position] = state.baggage[position].not()
        } else {
           setError(ErrorStatus.BAGGAGE)
        }
    }

    fun getSites(input: String) {
        if (input.isBlank()) {
            state = state.copy(
                responsePlace = emptyList()
            )
        }
        else {
            viewModelScope.launch(Dispatchers.IO) {
                //var aux = emptyList<Prediction>()
                repository.getPlaces(input).onSuccess { response ->
                    state = state.copy(
                        responsePlace = response.predictions
                    )
                }.onFailure {
                    setError(ErrorStatus.CITIES)
                    Log.i("ERROR: ", "${it.printStackTrace()}")
                }
            }
        }
    }
    private fun dynamicLoading() {
        state = state.copy(
            isLoading = !state.isLoading
        )
    }

    fun passengerPlus( ) {
        if (state.passengers in 0..2) {
            val aux = state.passengers + 1
            state = state.copy(
                passengers = aux
            )
        }
    }
    fun childrenPlus() {
        if (state.children in 0..2) {
            val aux = state.children + 1
            state = state.copy(
                children = aux
            )
        }
    }
    fun passengerMinus() {
        if (state.passengers in 1..3) {
            val aux = state.passengers - 1
            state = state.copy(
                passengers = aux
            )
        }
    }
    fun childrenMinus() {
        if (state.children in 1..3) {
            val aux = state.children - 1
            state = state.copy(
                children = aux
            )
        }
    }
    private fun setError(errorStatus: ErrorStatus) {
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