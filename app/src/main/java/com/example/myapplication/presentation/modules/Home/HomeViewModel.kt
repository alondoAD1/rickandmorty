package com.example.myapplication.presentation.modules.Home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Result
import com.example.myapplication.domain.model.UIHomeModel
import com.example.myapplication.domain.usecases.GETCharactersUseCase
import com.example.myapplication.presentation.Navigation.graph.HomeScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


//character/?page=1
//class HomeViewModel (): ViewModel() {
@HiltViewModel
    class HomeViewModel @Inject constructor(
    private val useCase: GETCharactersUseCase
): ViewModel() {

    var state by mutableStateOf(UIHomeState())

    init {
        fetch()
    }

    fun fetch() {
        state = state.copy(loading = false)
        viewModelScope.launch {
            try {
                val data = useCase.invoke()
                state = state.copy(data = data)
                state = state.copy(loading = true)
            } catch (e: Exception) {
                state = state.copy(loading = true)
                Log.e("error: ", e.toString())
            }
        }
    }

    fun onEvent(event: HomeEvent) {
        when(event) {

            is HomeEvent.onBackClick ->  {
                viewModelScope.launch {
                    event.dispatcher.onBackPressed()
                }
            }

            is HomeEvent.onGoDescriptionScreen -> {
                viewModelScope.launch {
                    event.navigationController.navigate("${HomeScreen.Detail.route}/${event.index}")
                }
            }

        }
    }

    data class UIHomeState(
        var loading: Boolean = false,
        val data: List<Result>? = emptyList(),
        val model: UIHomeModel? = null,
        val searchText: String = ""
    )
}
