package com.juntas.juntas_app.shared_components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juntas.juntas_app.journey_screen.presentation.JourneyScreen
import com.juntas.juntas_app.preference_screen.presentation.PreferenceScreen

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    //val navBackStackEntry by navController.currentBackStackEntryAsState()
    //val currentDestination = navBackStackEntry?.destination
    val bottomBar =  BottomBar()
    val topBar = TopBar(
        onProfileClicked = { /*TODO*/ },
        onNotificationsClicked = { /*TODO*/ },
        imageUrl = ""
    )

    NavHost(
        navController = navController ,
        startDestination = "journey_screen",
    ) {
        composable("journey_screen") {
            JourneyScreen( goAhead = { navController.navigate("preference_screen") } )
        }

        composable("preference_screen") {
            PreferenceScreen(onBackClicked = { navController.navigateUp() })
        }
    }
}