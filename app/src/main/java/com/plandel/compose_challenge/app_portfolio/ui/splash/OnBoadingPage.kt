package com.plandel.compose_challenge.app_portfolio.ui.splash

import androidx.annotation.DrawableRes
import com.plandel.compose_challenge.R

sealed class OnBoadingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First :
        OnBoadingPage(R.drawable.first, "Be Free", "Discover everything that's app have.")

    object Second :
        OnBoadingPage(R.drawable.second, "Be Aware", "Discover everything that's app have.")
}
