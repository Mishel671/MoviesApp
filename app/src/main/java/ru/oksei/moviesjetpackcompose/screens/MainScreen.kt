package ru.oksei.moviesjetpackcompose.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import ru.oksei.moviesjetpackcompose.MainViewModel
import ru.oksei.moviesjetpackcompose.data.models.MoviesDto
import ru.oksei.moviesjetpackcompose.navigation.Screens

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val moviesList = viewModel.moviesList.observeAsState(listOf()).value
    Log.d("MainLog", moviesList.toString())
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        items(moviesList) { item ->
            MovieItem(item = item, navController)
        }
    }
}

@Composable
fun MovieItem(item: MoviesDto, navController: NavController) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(route = Screens.Detail.route +"/${item.id}")
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberImagePainter(item.image.medium),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(
                    text = item.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Row{
                    Text(
                        text = "Rating: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item.rating.average.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(
                        text = "Genre: ",
                        fontWeight = FontWeight.Bold
                    )
                    item.genres.take(2).forEach {
                        Text(
                            text = " $it "
                        )
                    }
                }
                Row {
                    Text(
                        text = "Premiered: ",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item.premiered
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ListPreview() {
    MainScreen(rememberNavController(), hiltViewModel())
}