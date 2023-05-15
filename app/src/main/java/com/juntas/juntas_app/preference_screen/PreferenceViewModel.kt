package com.juntas.juntas_app.preference_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.juntas.juntas_app.preference_screen.presentation.PreferenceState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PreferenceViewModel @Inject constructor(

) : ViewModel() {
    var state by mutableStateOf(PreferenceState())
        private set

    fun changeSmoker() {
        state = state.copy(
            smokers = !state.smokers
        )
    }
    fun changePet() {
        state = state.copy(
            petfriendly = !state.petfriendly
        )
    }
    fun changeChildren() {
        state = state.copy(
            children = !state.children
        )
    }
    fun changeAllergy() {
        state = state.copy(
            allergy = !state.allergy
        )
    }
    fun changeChair() {
        state = state.copy(
            chainWheel = !state.chainWheel
        )
    }
    fun changeMedication() {
        state = state.copy(
            medication = !state.medication
        )
    }
    fun allergyText(text: String) {
        state = state.copy(
            allergyText = text
        )
    }
    fun chairText(text: String) {
        state = state.copy(
            chainWheelText = text
        )
    }
    fun medicationText(text: String) {
        state = state.copy(
            medicationText = text
        )
    }
    fun otherText(text: String) {
        state = state.copy(
            otherInfo = text
        )
    }
}