package com.yuwin.hotelapp_v2.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage
import com.yuwin.hotelapp_v2.R
import com.yuwin.hotelapp_v2.components.BottomNavigationBar
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme
import com.yuwin.hotelapp_v2.util.NavigationDestination
import com.yuwin.hotelapp_v2.util.SearchResults
import com.yuwin.hotelapp_v2.util.searchResultList

@Composable
fun SearchScreen(navController: NavController) {
    val text = remember { mutableStateOf(TextFieldValue()) }


    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                selectedItem = NavigationDestination.Search
            )
        },
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchBar(text)
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn {
                items(searchResultList) { item ->
                    SearchItem(data = item) {

                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(text: MutableState<TextFieldValue>) {
    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        SearchView(state = text)
        Spacer(modifier = Modifier.width(16.dp))
        FilterButton(onClick = {})
    }

}

@Composable
fun RowScope.SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        label = {
            Text(text = "Search", color = HotelTheme.colors.darkTextColor)
        },
        modifier = Modifier
            .weight(5.5f)
            .clip(RoundedCornerShape(5.dp)),
        textStyle = TextStyle(color = HotelTheme.colors.darkTextColor, fontSize = 18.sp),
        leadingIcon = {
            IconButton(
                onClick = {
                    state.value =
                        TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                }
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(28.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = HotelTheme.colors.darkTextColor,
            cursorColor = HotelTheme.colors.darkTextColor,
            leadingIconColor = HotelTheme.colors.darkTextColor,
            trailingIconColor = HotelTheme.colors.darkTextColor,
            backgroundColor = HotelTheme.colors.searchBarColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun RowScope.FilterButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(56.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(HotelTheme.colors.bottomBarBackgroundColor)
            .clickable(enabled = true, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "Filter",
            tint = Color.White
        )
    }
}

@Composable
fun SearchItem(data: SearchResults, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
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
                    text = "${data.ratings} Stars",
                    style = HotelTheme.typography.body2,
                    fontWeight = FontWeight.Medium
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