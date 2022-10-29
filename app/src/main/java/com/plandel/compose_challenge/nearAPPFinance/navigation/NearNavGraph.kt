package com.plandel.compose_challenge.nearAPPFinance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.plandel.compose_challenge.nearAPPFinance.home.NearHomeScreen

@Composable
fun NearNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NearScreen.NearHomeScreen.route) {

        composable(NearScreen.NearHomeScreen.route) {
            NearHomeScreen(navController)
        }

        composable(NearScreen.NearDetailsScreen.route, arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )) {

        }
    }
}