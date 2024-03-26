package com.example.myapplication.data.datasource.remote.api

import com.example.myapplication.data.model.HomeModel
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiService {

    @GET("character/?page=1")
    suspend fun getCharacter(): Response<HomeModel>
}