package com.juntas.juntas_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juntas.juntas_app.shared_components.LoadingDialog
import com.juntas.juntas_app.shared_components.Navigation
import com.juntas.juntas_app.trip_screen.presentation.TripScreen
import com.juntas.juntas_app.trip_screen.presentation.components.TripCard
import com.juntas.juntas_app.ui.theme.JuntasAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuntasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //JourneyScreen({})
                    //PreferenceScreen(onBackClicked = { /*TODO*/ })
                    //ManyDialog(onDismiss = { /*TODO*/ })
                    //Navigation()
                    //TripScreen()
                    LoadingDialog()
                    //SearchingDialog(onDismiss = { /*TODO*/ })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JuntasAppTheme {
        Greeting("Android")
    }
}