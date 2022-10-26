package com.yuwin.hotelapp_v2.ui.theme

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.yuwin.hotelapp_v2.ui.theme.apptheme.HotelColors
import com.yuwin.hotelapp_v2.ui.theme.apptheme.HotelTypography

private object HotelRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = Color.White

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.White,
        lightTheme = true
    )
}

val LocalHotelColors = staticCompositionLocalOf { HotelColors() }
val LocalHotelTypography = staticCompositionLocalOf { HotelTypography() }

object HotelTheme {

    val colors
        @Composable
        @ReadOnlyComposable
        get() = LocalHotelColors.current

    val typography
        @Composable
        @ReadOnlyComposable
        get() = LocalHotelTypography.current

}

@Composable
fun HotelAppv2Theme(content: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.isStatusBarVisible = false
        systemUiController.setNavigationBarColor(Color(0xFF1C1C1C))
    }

    CompositionLocalProvider(
        LocalRippleTheme provides HotelRippleTheme,
        LocalHotelColors provides HotelColors(),
        LocalHotelTypography provides HotelTypography(),
        content = content
    )
}