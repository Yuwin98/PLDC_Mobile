package com.yuwin.hotelapp_v2.util

import com.yuwin.hotelapp_v2.R
import com.yuwin.hotelapp_v2.navigation.Screens

sealed class NavigationDestination(var route: String, var icon: Int, var title: String) {
    object Home : NavigationDestination(Screens.HOME.route, R.drawable.ic_home, "Home")
    object Search : NavigationDestination(Screens.SEARCH.route, R.drawable.ic_search, "Search")
    object Bookings : NavigationDestination(Screens.BOOKED.route, R.drawable.ic_booked, "Bookings")
    object Profile : NavigationDestination(Screens.PROFILE.route, R.drawable.ic_profile, "Profile")
}