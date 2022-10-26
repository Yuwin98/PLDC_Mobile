package com.yuwin.hotelapp_v2.presentation.bookings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import com.yuwin.hotelapp_v2.components.BottomNavigationBar
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.Booking
import com.yuwin.hotelapp_v2.util.NavigationDestination
import com.yuwin.hotelapp_v2.util.bookingList

@Composable
fun BookingsScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedItem = NavigationDestination.Bookings
            )
        },
        topBar = {
            BookingTopAppBar()
        },
        backgroundColor = HotelTheme.colors.appBackground
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {

            items(bookingList) { item ->
                BookingItem(data = item)
            }

        }
    }

}

@Composable
fun BookingItem(data: Booking) {

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .height(350.dp)
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            GlideImage(
                imageModel = data.img,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Text(
                text = data.name,
                style = HotelTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = data.location,
                style = HotelTheme.typography.overline,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${data.guestNumber} ${if (data.guestNumber > 1) " guests" else " guest"} From: ${data.from} To:${data.to}",
                style = HotelTheme.typography.body2,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "PAID",
                color = HotelTheme.colors.successColor,
                style = HotelTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .fillMaxWidth()
            )


        }
    }

}

@Composable
fun BookingTopAppBar() {

    val textStyle = HotelTheme.typography.h6

    TopAppBar(
        title = { Text(text = "Bookings", style = textStyle, color = Color.White) },
        backgroundColor = HotelTheme.colors.darkTextColor,
        elevation = 5.dp
    )
}