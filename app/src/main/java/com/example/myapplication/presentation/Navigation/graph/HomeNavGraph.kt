package com.example.myapplication.presentation.Navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.myapplication.Navigation.graph.Graph
import com.example.myapplication.presentation.modules.Description.DescriptionScreen
import com.example.myapplication.presentation.modules.Home.HomeScreen

class HomeNavGraph {
}

sealed class HomeScreen(val route: String) {
    object Home: HomeScreen(route = "home_screen")
    object Detail: HomeScreen(route = "detail_screen")
}

fun NavGraphBuilder.homeNavGraph(navController: NavController) {

    navigation(
        route = Graph.HOME,
        startDestination = HomeScreen.Home.route
    ) {
        composable(route = HomeScreen.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = "${HomeScreen.Detail.route}/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) {
            DescriptionScreen(navController = navController)
        }
    }

}