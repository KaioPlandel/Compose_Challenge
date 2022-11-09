package com.plandel.compose_challenge.nearAPPFinance.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Transition(
    val coin: String,
    val type: String,
    val amount: String,
    val image: ImageVector
)
