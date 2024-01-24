package com.juntas.juntas_app.shared_components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.juntas.juntas_app.home_screen.HomeScreen
import com.juntas.juntas_app.journey_create_first.domain.JourneyCreate
import com.juntas.juntas_app.journey_screen.presentation.JourneyScreen
import com.juntas.juntas_app.login_screen.LoginScreen
import com.juntas.juntas_app.preference_screen.presentation.PreferenceScreen
import com.juntas.juntas_app.trip_screen.presentation.TripScreen

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val imageUrl = remember {
        mutableStateOf("https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg")
    }

    val bottomBar: @Composable () -> Unit = {
        BottomBar(
            currentDestination = currentDestination,
            onHomeClicked = { navController.navigate("home_screen") },
            onPassengerClicked = { navController.navigate("journey_screen") },
            onDriverClicked = { navController.navigate("journey_create_screen") }
        )
    }
    val topBar: @Composable () -> Unit = {
        TopBar(
            onCloseSession = {
                navController.navigate("login_screen")
                             },
            onNotificationsClicked = { /*TODO*/ },
            imageUrl = imageUrl.value
        )
    }


    NavHost(
        navController = navController ,
        startDestination = "login_screen",
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

        composable("journey_create_screen") {
            JourneyCreate(
                topBar = topBar,
                bottomBar = bottomBar
            )
        }
        composable("home_screen") {
            HomeScreen(
                topBar = topBar,
                bottomBar = bottomBar
            )
        }

        composable("trip_screen") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                TripScreen(
                    onBackClicked = { /*TODO*/ },
                    bottomBar = bottomBar,
                    topBar = topBar
                )
            }
        }

        composable("login_screen") {
            LoginScreen(
                loginOk = {
                    navController.navigate("home_screen") {
                        popUpTo("login_screen")
                        launchSingleTop = true
                        restoreState = true
                    }
                    imageUrl.value = it
                }
            )
        }
    }
}