package com.plandel.compose_challenge.app_portfolio.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.plandel.compose_challenge.ui.theme.backgroundSplash
import com.plandel.compose_challenge.ui.theme.button

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PortSplashScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    val pages = listOf(
        OnBoadingPage.First,
        OnBoadingPage.Second
    )

    val pageState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundSplash),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            count = 2,
            state = pageState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(0.7f)
        ) { position ->
            ScreenSplashItem(onBoadingPage = pages[position])
        }

        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .weight(0.3f)
                .align(Alignment.CenterHorizontally),
            activeColor = Color.Green,
            inactiveColor = Color.LightGray,
            indicatorWidth = 13.dp,
            spacing = 10.dp
        )
        ButtonGoToApp(text = "Get Started", state = pageState, modifier = Modifier.weight(1f))

    }
}


@Composable
fun ScreenSplashItem(onBoadingPage: OnBoadingPage, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.backgroundSplash),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = onBoadingPage.image),
            contentDescription = onBoadingPage.title,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = onBoadingPage.title,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = onBoadingPage.description,
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ButtonGoToApp(
    text: String,
    state: PagerState,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(visible = state.currentPage == 1, modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(MaterialTheme.colors.button)
                .padding(13.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(text = text, color = Color.Black, fontSize = 22.sp, textAlign = TextAlign.Center)
        }
    }
}