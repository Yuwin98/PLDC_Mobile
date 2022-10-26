package com.yuwin.hotelapp_v2.navigation

import com.yuwin.hotelapp_v2.util.Routes

sealed class Screens(val route: String) {
    object SPLASH : Screens(Routes.SPLASH_SCREEN)
    object LOGIN : Screens(Routes.LOGIN_SCREEN)
    object SIGNUP : Screens(Routes.SIGNUP_SCREEN)
    object HOME : Screens(Routes.HOME_SCREEN)
    object SEARCH : Screens(Routes.SEARCH)
    object PROFILE : Screens(Routes.PROFILE_SCREEN)
    object BOOKED : Screens(Routes.BOOKED_SCREEN)
    object CHECKOUT : Screens(Routes.BOOK_SCREEN)
    object SELECTED : Screens(Routes.SELECTED_HOTEL_SCREEN)
}
