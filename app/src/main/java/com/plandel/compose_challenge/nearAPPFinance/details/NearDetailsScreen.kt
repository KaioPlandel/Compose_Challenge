package com.plandel.compose_challenge.nearAPPFinance.details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.plandel.compose_challenge.nearAPPFinance.navigation.NearScreen

@Composable
fun NearDetailsScreen(navController: NavHostController) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        DetailTopBar(buttonText = "Add alert", navController = navController)
        Spacer(modifier = Modifier.height(15.dp))
        DetailsMoneyScreen("$21.560,30","+ $4.915,6","22,8%")
    }
}

@Composable
fun DetailTopBar(
    modifier: Modifier = Modifier,
    buttonText: String,
    navController: NavHostController
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(30.dp)
                .clickable { navController.navigate(NearScreen.NearHomeScreen.route) }
        )
        Box(
            modifier = Modifier
                .padding(5.dp)
                .border(2.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .padding(horizontal = 20.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = buttonText, fontSize = 14.sp, color = Color.LightGray)
        }
    }
}

@Composable
fun DetailsMoneyScreen(
    firstPrice: String,
    secondPrice: String,
    thirdPrice: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "Bitcoin price", color = Color.LightGray, fontSize = 16.sp)
        Text(text = firstPrice, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp, horizontal = 15.dp)
            ) {
                Text(text = secondPrice, color = Color.Green, fontSize = 16.sp)
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color.LightGray)
                    .padding(vertical = 8.dp, horizontal = 15.dp)
            ) {
                Text(text = thirdPrice, color = Color.Green, fontSize = 16.sp)
            }
        }
    }
}