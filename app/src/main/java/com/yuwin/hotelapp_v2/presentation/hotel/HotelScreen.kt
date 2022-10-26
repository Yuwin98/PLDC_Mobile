package com.yuwin.hotelapp_v2.presentation.hotel

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yuwin.hotelapp_v2.components.BottomNavigationBar
import com.yuwin.hotelapp_v2.presentation.bookings.BookingTopAppBar
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.NavigationDestination

@Composable
fun HotelScreen(navController: NavController) {

    Scaffold(
        topBar = {
            DescriptionTopAppBar()
        },
        backgroundColor = HotelTheme.colors.appBackground
    ) { it }


}

@Composable
fun DescriptionTopAppBar() {

    val textStyle = HotelTheme.typography.h6

    TopAppBar(
        title = { Text(text = "Description", style = textStyle, color = Color.White) },
        backgroundColor = HotelTheme.colors.darkTextColor,
        elevation = 5.dp
    )
}