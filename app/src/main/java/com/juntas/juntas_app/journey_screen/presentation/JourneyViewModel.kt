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

    fun getRoute(origin: String, destination: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val aux = repository.getSpecificRoute(state.origin, state.destination)
            if (aux.isSuccess) {
                Log.i("LIST", "${aux.onSuccess { value -> value.status }}")
            } else {
                Log.i("ERROR", "Msg")
            }
        }
    }

}