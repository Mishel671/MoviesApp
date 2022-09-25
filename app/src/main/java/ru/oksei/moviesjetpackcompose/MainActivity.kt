package ru.oksei.moviesjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.oksei.moviesjetpackcompose.navigation.SetupNavHost
import ru.oksei.moviesjetpackcompose.ui.theme.MoviesJetpackComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesJetpackComposeTheme {
                val navController = rememberNavController()
                val viewModel= hiltViewModel<MainViewModel>()
                SetupNavHost(navController = navController, viewModel = viewModel)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesJetpackComposeTheme {

    }
}