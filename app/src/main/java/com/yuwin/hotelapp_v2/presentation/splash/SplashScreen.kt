package com.yuwin.hotelapp_v2.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yuwin.hotelapp_v2.R
import com.yuwin.hotelapp_v2.navigation.Screens
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = Unit) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Screens.LOGIN.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HotelTheme.colors.bottomBarBackgroundColor),
        contentAlignment = Alignment.Center
    ) {

        GlideImage(
            modifier = Modifier.size(100.dp),
            imageModel = R.drawable.hotel,
            requestOptions = RequestOptions().override(128),
            colorFilter = ColorFilter.tint(Color.White)
        )

    }
}