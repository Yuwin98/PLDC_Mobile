package com.yuwin.hotelapp_v2.presentation.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yuwin.hotelapp_v2.R
import com.yuwin.hotelapp_v2.components.BottomNavigationBar
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.NavigationDestination

@Composable
fun ProfileScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedItem = NavigationDestination.Profile
            )
        },
        backgroundColor = HotelTheme.colors.appBackground
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {


            ProfileImage()
            Spacer(modifier = Modifier.height(16.dp))

            RowButton(name = "Privacy") {

            }
            RowButton(name = "Bookings") {

            }
            RowButton(name = "Payments") {

            }

            RowButton(name = "Settings") {

            }
            RowButton(name = "LogOut") {

            }

        }
    }

}

@Composable
fun ProfileImage() {
    Column(
        modifier = Modifier
            .padding(top = 24.dp, start = 32.dp, end = 32.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dave Wells",
            style = HotelTheme.typography.subtitle1,
            fontWeight = FontWeight.SemiBold
        )
        GlideImage(
            modifier = Modifier
                .size(130.dp),
            imageModel = R.drawable.profile,
            requestOptions = RequestOptions().circleCrop()
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "davewells97@gmail.com",
            style = HotelTheme.typography.body1,
            fontWeight = FontWeight.Normal,
            color = HotelTheme.colors.secondaryTextColor
        )
    }

}

@Composable
fun RowButton(name: String, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable(enabled = true, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = name,
            style = HotelTheme.typography.subtitle1
        )
    }

}