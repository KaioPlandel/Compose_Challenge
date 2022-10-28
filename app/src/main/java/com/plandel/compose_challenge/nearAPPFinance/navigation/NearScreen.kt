package com.plandel.compose_challenge.nearAPPFinance.navigation

sealed class NearScreen(val route: String) {

    object NearHomeScreen : NearScreen("near_home_screen")
    object NearDetailsScreen : NearScreen("near_details_screen/id") {
        fun setId(id: Int): String {
            return "near_details_screen/${id}"
        }
    }
}
