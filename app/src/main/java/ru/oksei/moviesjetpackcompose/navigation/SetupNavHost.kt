package ru.oksei.moviesjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.oksei.moviesjetpackcompose.MainViewModel
import ru.oksei.moviesjetpackcompose.screens.DetailScreen
import ru.oksei.moviesjetpackcompose.screens.MainScreen
import ru.oksei.moviesjetpackcompose.screens.SplashScreen
import ru.oksei.moviesjetpackcompose.utils.Constants

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Detail.route + "/{Id}") { backStackEntry ->
            DetailScreen(
                viewModel = viewModel,
                backStackEntry.arguments?.getString("Id") ?: "1"
            )
        }
    }
}

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Detail : Screens(route = Constants.Screens.DETAILS_SCREEN)
}