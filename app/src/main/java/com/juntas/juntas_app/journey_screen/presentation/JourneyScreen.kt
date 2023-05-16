package com.juntas.juntas_app.journey_screen.presentation

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.juntas.juntas_app.journey_screen.presentation.components.MapsView
import com.juntas.juntas_app.journey_screen.presentation.components.TittleBox
import com.juntas.juntas_app.journey_screen.presentation.components.TittleSearch
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun JourneyScreen(
    goAhead: () -> Unit,
    viewModel: JourneyViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.state
    val toPreferenceContext = remember {
        mutableStateOf(false)
    }
    val current = LocalContext.current

    //when (state.error) {
    //    ErrorStatus.DATE -> Toast.makeText(current, "Error: Date", Toast.LENGTH_SHORT).show()
    //    ErrorStatus.SITES -> Toast.makeText(current, "Error: SITES", Toast.LENGTH_SHORT).show()
    //    ErrorStatus.BAGGAGE -> Toast.makeText(current, "Error: BAGGAGE", Toast.LENGTH_SHORT).show()
    //    ErrorStatus.CITIES -> Toast.makeText(current, "Error: CITIES", Toast.LENGTH_SHORT).show()
    //    else -> {}
    //}

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar({/*TODO: Set clicked functions */}, {}, "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg") } ,
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,

        ) {

            item {
                AnimatedVisibility(
                    visible = !toPreferenceContext.value,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TittleBox()
                }
            }
            item {
                AnimatedVisibility(
                    visible = !toPreferenceContext.value,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TittleSearch()
                }
            }
            item {
                MapsView(
                    onContinueClicked = {
                        if (!toPreferenceContext.value) toPreferenceContext.value = true
                            else goAhead()
                                        } ,
                    passenger = state.passengers ,
                    children =  state.children,
                    toPreferenceContext = toPreferenceContext.value,
                    onMinusChildren = { viewModel.childrenMinus() },
                    onPlusChildren = { viewModel.childrenPlus() },
                    onMinusPassenger = { viewModel.passengerMinus() },
                    onPlusPassenger = { viewModel.passengerPlus() },
                    predictions = state.responsePlace,
                    getSite = { viewModel.getSites(it) }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun JourneyScreenPreview() {
    JourneyScreen({})
}
