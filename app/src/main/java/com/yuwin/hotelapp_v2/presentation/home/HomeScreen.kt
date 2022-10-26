package com.yuwin.hotelapp_v2.presentation.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yuwin.hotelapp_v2.R
import com.yuwin.hotelapp_v2.components.BottomNavigationBar
import com.yuwin.hotelapp_v2.navigation.Screens
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.*

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedItem = NavigationDestination.Home
            )
        },
        backgroundColor = Color.White
    ) {

        Column(
            modifier = Modifier.padding(it)
        ) {
            WelcomeScreen()
            PopularHotels {
                navController.navigate(Screens.SELECTED.route)
            }
            RecommendedHotels {
                navController.navigate(Screens.SELECTED.route)
            }

        }

    }

}

@Composable
fun WelcomeScreen() {
    Row(
        modifier = Modifier
            .padding(start = 32.dp, top = 24.dp, bottom = 24.dp, end = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Welcome Back!",
                style = HotelTheme.typography.h6,
                color = HotelTheme.colors.darkTextColor,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Hi, Dave Wells",
                style = HotelTheme.typography.button,
                color = HotelTheme.colors.darkTextColor,
                fontWeight = FontWeight.Medium
            )
        }

        GlideImage(
            modifier = Modifier.size(56.dp),
            imageModel = R.drawable.profile,
            requestOptions = RequestOptions().circleCrop()
        )
    }

}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp, top = 32.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = HotelTheme.typography.subtitle1,
            color = HotelTheme.colors.primary,
            fontWeight = FontWeight.SemiBold
        )

        TextButton(modifier = Modifier.fillMaxHeight(), onClick = { }) {
            Text(
                text = "View all",
                style = HotelTheme.typography.subtitle2,
                color = HotelTheme.colors.darkTextColor
            )
        }


    }

}

@Composable
fun PopularHotels(onClick: () -> Unit) {
    SectionHeader(title = "Popular Hotels")
    LazyRow(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        items(popularHotels) { item ->
            PopularHotelCard(item, onClick)
        }
    }
}

@Composable
fun RecommendedHotels(onClick: () -> Unit) {
    SectionHeader(title = "Recommended")
    LazyColumn(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        items(recommendedHotels) { item ->
            RecommendedHotelCard(item, onClick)
        }

    }
}

@Composable
fun PopularHotelCard(data: PopularHotels, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .clickable(enabled = true, onClick = onClick)
    ) {
        Column {
            GlideImage(
                imageModel = data.img,
                contentScale = ContentScale.Crop,
                requestOptions = RequestOptions().override(256),
                modifier = Modifier.height(175.dp)
            )
            Text(
                text = data.name,
                style = HotelTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

        }

    }
}

@Composable
fun RecommendedHotelCard(data: RecommendedHotels, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White)
            .clickable(enabled = true, onClick = onClick)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            GlideImage(
                imageModel = data.img,
                contentScale = ContentScale.Crop,
                requestOptions = RequestOptions().override(256),
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = data.name,
                    style = HotelTheme.typography.body1,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = data.price,
                    style = HotelTheme.typography.body2,
                    fontWeight = FontWeight.Medium
                )
                Text(text = data.location, style = HotelTheme.typography.overline)
            }
        }
    }
}
