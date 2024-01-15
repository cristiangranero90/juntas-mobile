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
    val bottomBar: @Composable () -> Unit = {
        BottomBar()
    }
    val topBar: @Composable () -> Unit = {
        TopBar(
            onProfileClicked = { /*TODO*/ },
            onNotificationsClicked = { /*TODO*/ },
            imageUrl = "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg"
        )
    }


    NavHost(
        navController = navController ,
        startDestination = "journey_screen",
    ) {
        composable("journey_screen") {
            JourneyScreen(
                goAhead = { navController.navigate("preference_screen") },
                topBar = topBar,
                bottomBar = bottomBar
            )
        }

        composable("preference_screen") {
            PreferenceScreen(
                onBackClicked = { navController.navigateUp() },
                topBar = topBar,
                bottomBar = bottomBar
            )
        }
    }
}