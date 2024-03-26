package com.example.myapplication.presentation.modules.Home

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.NavController

sealed class HomeEvent {

    data class onBackClick(val dispatcher: OnBackPressedDispatcher): HomeEvent()
    data class onGoDescriptionScreen(val navigationController: NavController, val index: String): HomeEvent()

}