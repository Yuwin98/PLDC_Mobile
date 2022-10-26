package com.yuwin.hotelapp_v2.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yuwin.hotelapp_v2.navigation.Screens
import com.yuwin.hotelapp_v2.ui.theme.HotelTheme

@Composable
fun LoginScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Log In", style = HotelTheme.typography.h3)
            Spacer(modifier = Modifier.weight(1f))
            LoginForm(
                login = { navController.navigate(Screens.HOME.route) },
                signUp = { navController.navigate(Screens.SIGNUP.route) }
            )
            Spacer(modifier = Modifier.weight(3f))
        }
    }
}

@Composable
fun LoginForm(login: () -> Unit, signUp: () -> Unit) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Eg: abc@email.com") },
        )
        TextField(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 8.dp)
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Eg: abc123@") },
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TextButton(onClick = { }) {
                Text(
                    text = "Forgot Password",
                    style = HotelTheme.typography.subtitle2,
                    color = Color.Black.copy(0.6f)
                )
            }
            TextButton(onClick = signUp) {
                Text(
                    text = "SignUp",
                    style = HotelTheme.typography.subtitle2,
                    color = Color.Black.copy(0.6f)
                )
            }
        }

        Button(
            modifier = Modifier
                .padding(top = 16.dp, start = 32.dp, end = 32.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            onClick = login,
            colors = ButtonDefaults.buttonColors(backgroundColor = HotelTheme.colors.primary)
        ) {
            Text(text = "LOGIN", style = HotelTheme.typography.subtitle2, color = Color.White)
        }
    }
}