package com.yuwin.hotelapp_v2.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.NavigationDestination

@Composable
fun BottomNavigationBar(navController: NavController, selectedItem: NavigationDestination) {
    val items = listOf(
        NavigationDestination.Home,
        NavigationDestination.Search,
        NavigationDestination.Bookings,
        NavigationDestination.Profile
    )
    BottomNavigation(
        backgroundColor = HotelTheme.colors.bottomBarBackgroundColor,
        contentColor = HotelTheme.colors.bottomBarContentColor
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.title) },
                selectedContentColor = HotelTheme.colors.bottomBarContentColor,
                unselectedContentColor = Color.Gray.copy(0.6f),
                alwaysShowLabel = true,
                selected = item == selectedItem,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}