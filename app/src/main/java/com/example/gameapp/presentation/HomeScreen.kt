package com.example.gameapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.gameapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gameapp.ui.theme.textColor


@Composable
fun HomeScreen(
    navController: NavController
){
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            BackgroundImage()

        }
        Gretting(navController = navController)
    }
}




@Composable
fun BackgroundImage(){
   Image(
       painter = painterResource(id = R.drawable.img),
       contentDescription = "backgroung image",
       modifier = Modifier
           .fillMaxSize()
   )
}


@Composable
fun Gretting(
     navController: NavController
){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Adding Fun to",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(5.dp)
        )
        Text(
            text = "Your Life",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(2.dp)
        )
        Text(
            text = "we provides make more",
            style = MaterialTheme.typography.h6,
            color = textColor,
            modifier = Modifier
                .padding(top = 30.dp)
        )
        Text(
            text = "experince for playing real games",
            style = MaterialTheme.typography.h6,
            color = textColor,
            modifier = Modifier
                .padding(top = 2.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(top = 100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Red)
                .height(70.dp)
                .width(250.dp)
                .shadow(elevation = 1.5.dp)
                .clickable {
                    navController.navigate("game_screen")
                }
        ) {
            Text(
                text = "Get Started",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
        }
    }
}


