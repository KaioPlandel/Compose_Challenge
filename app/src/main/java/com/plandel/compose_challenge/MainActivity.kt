package com.plandel.compose_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.plandel.compose_challenge.nearAPPFinance.navigation.NearNavGraph
import com.plandel.compose_challenge.ui.theme.Compose_ChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ChallengeTheme {
                val navController  = rememberNavController()

                NearNavGraph(navController = navController)
            }
        }
    }
}
