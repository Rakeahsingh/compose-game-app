package com.example.gameapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.gameapp.R
import com.example.gameapp.data.Games
import com.example.gameapp.domain.GameViewModel
import com.example.gameapp.ui.theme.*

@Composable
fun GameScreen(
    navController: NavController,
    gameViewModel: GameViewModel = hiltViewModel()
) {
    val gameList by gameViewModel.gameList.collectAsState()

    Box(
        modifier = Modifier
            .background(DarkBlue)
            .fillMaxSize()
    ) {
        Column {
            TopGreeting(navController = navController)
            SearchView()
            BodyView(navController = navController, gameList = gameList)
        }
    }
}


@Composable
fun TopGreeting(
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "WELCOME",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(
                text = "what would you like to play?",
                style = MaterialTheme.typography.h6,
                color = textColor
            )
        }

        Spacer(
            modifier = Modifier
                .width(30.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "profile_image",
            modifier = Modifier
                .clip(CircleShape)
                .height(50.dp)
                .width(50.dp)


        )

    }
}


@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }

    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search_24),
            contentDescription = "search",
            modifier = modifier.padding(10.dp)
        )

        BasicTextField(value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .weight(1f)
                .onFocusChanged {

                }
        )

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(top = 5.dp, bottom = 10.dp, end = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Purple500)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_mic_24),
                contentDescription = "mic",
                modifier
                    .align(Center),
                tint = Color.White
            )
        }
    }

}


@Composable
fun BodyView(
    modifier: Modifier = Modifier,
    navController: NavController,
    gameList: List<Games>
) {
    Box(
        modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White)
            .padding(top = 30.dp)

    ) {

        Column {
            GameChipsList()
            PopularText()
            GameListSection(games = gameList, navController = navController)

        }

    }
}


@Composable
fun GameChipsList(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        ) {
            Box(
                modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(lightRed)
                    .shadow(elevation = 2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_unit_24),
                    contentDescription = "arcade",
                    modifier = Modifier
                        .size(34.dp)
                        .align(Center)
                )

                Text(
                    text = "Arcade",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(BottomCenter)
                        .padding(3.dp)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        ) {
            Box(
                modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(lightPurple)
                    .shadow(elevation = 2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_car_24),
                    contentDescription = "race",
                    modifier = Modifier
                        .size(34.dp)
                        .align(Center)
                )

                Text(
                    text = "Racing",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(BottomCenter)
                        .padding(3.dp)
                )
            }


        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        ) {
            Box(
                modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(lightGreen)
                    .shadow(elevation = 2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_mode_24),
                    contentDescription = "sratigity",
                    modifier = Modifier
                        .size(34.dp)
                        .align(Center)
                )

                Text(
                    text = "Stratigity",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(BottomCenter)
                        .padding(3.dp)
                )

            }

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
        ) {
            Box(
                modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(lightSky)
                    .shadow(elevation = 2.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_more_24),
                    contentDescription = "more",
                    modifier = Modifier
                        .size(34.dp)
                        .align(Center)
                )

                Text(
                    text = "More",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(BottomCenter)
                        .padding(3.dp)
                )
            }
        }
    }

}


@Composable
fun PopularText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Popular Games",
            color = Color.Black,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun GameListSection(
    games: List<Games>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(games.size) {
                GameListItem(game = games[it], navController = navController)
            }
        }
    }

}


@Composable
fun GameListItem(
    game: Games,
    navController: NavController
) {

    //val image = rememberAsyncImagePainter(model = games.thumbnail)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(146.dp)
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .background(DarkBlue)
            .clip(RoundedCornerShape(10.dp))
            .shadow(elevation = 1.5.dp)
            .clickable {
                navController.navigate("game_details/${game.id}")
            }
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            AsyncImage(
                model = game.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(115.dp)
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
            )

            Text(
                text = game.title,
                fontWeight = FontWeight.Bold,
                color = textColor,
                modifier = Modifier
                    .height(24.dp)
                    .padding(horizontal = 12.dp)
            )
        }

    }
}








