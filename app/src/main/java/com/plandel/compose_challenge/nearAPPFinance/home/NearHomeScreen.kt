package com.plandel.compose_challenge.nearAPPFinance.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NearHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopScreen(
            logo = painterResource(id = com.plandel.compose_challenge.R.drawable.img),
            perfilImage = painterResource(id = com.plandel.compose_challenge.R.drawable.boruto)
        )
        Spacer(modifier = Modifier.height(20.dp))
        AmountScreen(balance = "$8,850,73","6.980")
    }
}

@Composable
fun TopScreen(
    logo: Painter,
    perfilImage: Painter,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = logo, contentDescription = "logo",
            modifier = Modifier
                .padding(start = 110.dp)
                .size(120.dp)
        )
        Image(
            painter = perfilImage,
            contentDescription = "perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 30.dp)
                .size(38.dp)
                .clip(
                    CircleShape
                )
        )
    }
}

@Composable
fun AmountScreen(
    balance: String,
    money: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "My balance",
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = balance,
            fontSize = 46.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = money,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Gray)
                .padding(vertical = 8.dp, horizontal = 15.dp)
        )

    }
}