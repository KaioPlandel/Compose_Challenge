package com.plandel.compose_challenge.app_portfolio.navigation

sealed class PortScreen(val route: String){

    object PortSplashScreen: PortScreen(route = "port_splash_screen")
    object PortHomeScreen: PortScreen(route = "port_home_screen")
}
