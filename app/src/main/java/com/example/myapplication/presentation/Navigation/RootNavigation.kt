package com.example.myapplication.Navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myapplication.presentation.Navigation.graph.homeNavGraph

class RootNavigation {
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
    const val DESC = "description_graph"
}

@Composable
fun RootNavigatinGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {
        homeNavGraph(
            navController = navController
        )

//        (
//            navController = navController,
//        )
    }

}