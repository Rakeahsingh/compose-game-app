package com.example.gameapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gameapp.presentation.gameDetailsViewModel.GameDetailsViewModel
import com.example.gameapp.ui.theme.DarkBlue
import com.example.gameapp.ui.theme.textColor

@Composable
fun GameDetailsScreen(
    navController: NavController,
    viewModel: GameDetailsViewModel = hiltViewModel()
){
    val game by viewModel.game.collectAsState()

    Box(
        modifier = Modifier
            .background(DarkBlue)
            .fillMaxSize()
    ){

        Column {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                tint = Color.White,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            AsyncImage(
                model = game?.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp)
                    .padding( start = 12.dp, end = 12.dp)
            )
            
           Box(modifier = Modifier
               .fillMaxSize()
               .padding(top = 20.dp)
               .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
               .background(Color.White)


           ){
               Column {



                   Text(
                       text = game?.title.toString(),
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 12.dp, start = 100.dp)

                   )

                   Text(
                       text = "Release-Date:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 30.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.release_date.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )

                   Text(
                       text = "Game-Plateform to Play:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 12.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.platform.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )

                   Text(
                       text = "Game-Type:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 12.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.genre.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )

                   Text(
                       text = "Game-Description:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 18.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.short_description.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )

                   Text(
                       text = "Game-Develop:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 18.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.developer.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )

                   Text(
                       text = "Game-Publiser:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 18.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.publisher.toString(),
                       color = Color.Red,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )


                   Text(
                       text = "Game-URL:",
                       color = Color.Black,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 18.dp,start = 10.dp)
                   )

                   Text(
                       text = game?.game_url.toString(),
                       color = Color.Blue,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier
                           .padding(top = 5.dp, start = 10.dp)

                   )
               }

           }

        }

    }
}




