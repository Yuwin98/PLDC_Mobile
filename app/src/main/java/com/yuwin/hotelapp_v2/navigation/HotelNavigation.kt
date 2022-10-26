package com.yuwin.hotelapp_v2.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.yuwin.hotelapp_v2.presentation.bookings.BookingsScreen
import com.yuwin.hotelapp_v2.presentation.home.HomeScreen
import com.yuwin.hotelapp_v2.presentation.hotel.HotelScreen
import com.yuwin.hotelapp_v2.presentation.login.LoginScreen
import com.yuwin.hotelapp_v2.presentation.profile.ProfileScreen
import com.yuwin.hotelapp_v2.presentation.search.SearchScreen
import com.yuwin.hotelapp_v2.presentation.signup.SignUpScreen
import com.yuwin.hotelapp_v2.presentation.splash.SplashScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HotelNavigation() {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.SEARCH.route
    ) {
        composable(route = Screens.SPLASH.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.LOGIN.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.SIGNUP.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screens.HOME.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.BOOKED.route) {
            BookingsScreen(navController = navController)
        }
        composable(route = Screens.SEARCH.route) {
            SearchScreen(navController = navController)
        }
        composable(route = Screens.SELECTED.route) {
            HotelScreen(navController = navController)
        }
        composable(route = Screens.PROFILE.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screens.CHECKOUT.route) {

        }
    }

}