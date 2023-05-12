package com.juntas.juntas_app.journey_screen.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    viewModel: JourneyViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.state


    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBar({/*TODO: Set clicked functions */}, {}, "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg") } ,
        bottomBar = { BottomBar() },
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = paddingValues,

        ) {

            item { TittleBox() }
            
            item { TittleSearch() }

            item { MapsView({ viewModel.getRoute("", "")}) }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
@Preview(showBackground = true)
fun JourneyScreenPreview() {
    JourneyScreen()
}
