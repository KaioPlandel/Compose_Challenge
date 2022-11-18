package com.plandel.compose_challenge.app_portfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plandel.compose_challenge.app_portfolio.ui.PortHomeScreen
import com.plandel.compose_challenge.app_portfolio.ui.splash.PortSplashScreen

@Composable
fun PortNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = PortScreen.PortHomeScreen.route) {
        composable(PortScreen.PortSplashScreen.route) {
            PortSplashScreen(navHostController = navController)
        }
        composable(PortScreen.PortHomeScreen.route) {
            PortHomeScreen(navController = navController)
        }
    }
}
