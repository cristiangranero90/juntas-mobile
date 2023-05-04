package com.juntas.juntas_app.journey_screen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juntas.juntas_app.shared_components.BottomBar
import com.juntas.juntas_app.shared_components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JourneyScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar({/*TODO: Set clicked functions */}, {}, "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg") } ,
        bottomBar = { BottomBar() },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Text(text = "new text", style = MaterialTheme.typography.bodyLarge)
        }

    }
}

@Composable
@Preview(showBackground = true)
fun JourneyScreenPreview() {
    JourneyScreen()
}
