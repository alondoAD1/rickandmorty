package com.example.myapplication.presentation.modules.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.modules.Home.common.MovieItem
import com.example.myapplication.domain.model.UIHomeModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val listFilter = viewModel.state.data?: emptyList()

    LazyColumn(modifier.testTag("HomeRecipeItems")
        .background(Color.LightGray)) {
        items(listFilter) { data ->
            MovieItem(movie = UIHomeModel(url = data.image,
                name = data.name,
                description = data.species?.value?: "",
                id = data.id,
                status = data.status?.value?: "",
                species = data.species?.value?: "",
                type = data.type,
                gender = data.gender?.value?: "",
                origin = data.origin?.name ?: "",
                location = data.location?.name?: ""
            )
            ) {
                viewModel.onEvent(
                    HomeEvent.onGoDescriptionScreen(
                        navigationController = navController,
                        it.toString()
                    )
                )
            }
        }
    }
}