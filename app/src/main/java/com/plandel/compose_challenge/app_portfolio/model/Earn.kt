package com.plandel.compose_challenge.app_portfolio.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Earn(
    val company: ImageVector,
    val title: String,
    val earn: String,
    val amount: String
)
