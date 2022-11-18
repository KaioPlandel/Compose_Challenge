package com.plandel.compose_challenge.nearAPPFinance.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.plandel.compose_challenge.nearAPPFinance.models.ItemImage
import com.plandel.compose_challenge.nearAPPFinance.models.Transition
import com.plandel.compose_challenge.nearAPPFinance.navigation.NearScreen

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
        AmountScreen(balance = "$8,850,73", "6.980", Modifier.clickable {
            navController.navigate(NearScreen.NearDetailsScreen.setId(1))
        })
        Spacer(modifier = Modifier.height(20.dp))
        MenuScreen(
            listOf(
                ItemImage("Send", Icons.Default.CheckCircle),
                ItemImage("Send", Icons.Default.CheckCircle),
                ItemImage("Send", Icons.Default.CheckCircle),
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "My Assets",
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        TransitionScreen(
            listOf(
                Transition("THERHER USD", "USDT", "$5.000,60", Icons.Default.Home),
                Transition("THERHER USD", "USDT", "$5.000,60", Icons.Default.Home),
                Transition("THERHER USD", "USDT", "$5.000,60", Icons.Default.Home),
                Transition("THERHER USD", "USDT", "$5.000,60", Icons.Default.Home),
                Transition("THERHER USD", "USDT", "$5.000,60", Icons.Default.Home),
            )
        )
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
                .background(Color(24, 26, 30))
                .padding(vertical = 8.dp, horizontal = 15.dp)
        )

    }
}

@Composable
fun MenuScreen(
    items: List<ItemImage>,
    modifier: Modifier = Modifier
) {
    var selected by remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        items(items.size) {
            val isSelectedColor = if (selected == it) Color.Blue else Color.DarkGray
                MenuItemScreen(item = items[it], isSelectedColor, Modifier.clickable {
                    selected = it
                })
        }
    }
}

@Composable
fun MenuItemScreen(
    item: ItemImage,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color)
            .height(100.dp)
            .width(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = item.image,
            contentDescription = item.name,
            colorFilter = ColorFilter.tint(Color.White)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.name, fontSize = 12.sp, color = Color.White)
    }
}

@Composable
fun TransitionScreen(
    transitions: List<Transition>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(transitions.size) {
            CardTransition(transition = transitions[it])
        }
    }
}


@Composable
fun CardTransition(
    transition: Transition,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(24, 26, 30))
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundedImage(image = transition.image)
        Spacer(modifier = Modifier.width(6.dp))
        Column {
            Text(text = transition.coin, fontSize = 16.sp, color = Color.White)
            Text(
                text = transition.type,
                fontSize = 14.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(95.dp))
        Text(text = transition.amount, fontSize = 18.sp, color = Color.White)
    }
}

@Composable
fun RoundedImage(
    image: ImageVector,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(5.dp)
            .clip(CircleShape)
            .background(Color.Blue)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}