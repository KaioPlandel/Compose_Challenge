package com.plandel.compose_challenge.app_portfolio.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.plandel.compose_challenge.R
import com.plandel.compose_challenge.ui.theme.BackgroundBox
import com.plandel.compose_challenge.ui.theme.BackgroundMenu
import com.plandel.compose_challenge.ui.theme.backgroundSplash

@Composable
fun PortHomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundSplash),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PToBar(money = "$22.580.500")
        ResumeScreen()
        MenuSection()
    }
}

@Composable
fun PToBar(money: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Your balance", color = Color.LightGray, fontSize = 14.sp)
            Text(text = money, color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }
        PortPhotoScreen(image = painterResource(id = R.drawable.boruto), Color.White)
    }
}

@Composable
fun PortPhotoScreen(image: Painter, colorBorder: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(end = 20.dp)
            .size(45.dp)
            .clip(CircleShape)
            .background(colorBorder)
            .padding(2.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ResumeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 25.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            CardItem()
            CardItem()
        }

    }
}

@Composable
fun CardItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(BackgroundBox)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                imageVector = Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(Color.Black),
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "$12.060.000",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Total Portfolio", color = Color.LightGray, fontSize = 12.sp)
        }
    }
}

@Composable
fun MenuSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 20.dp, top = 2.dp, end = 20.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BackgroundMenu)
    ) {

    }
}

















