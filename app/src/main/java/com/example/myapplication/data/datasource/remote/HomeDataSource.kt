package com.example.myapplication.Modules.Home.data.datasource.remote

import com.example.myapplication.data.model.Result
import com.example.myapplication.data.datasource.remote.api.HomeApiService
import com.example.myapplication.Service.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val networkManager: NetworkManager
) {

    suspend fun getCharacters(): List<Result>? {
        try {
            val result = networkManager.createApiService<HomeApiService>().getCharacter()
            if (result.isSuccessful) {
                val data = result.body()
                return withContext(Dispatchers.IO) {
                    data?.results
                }
            } else {
                throw Exception("Error en la solicitud: ${result.code()}")
            }
        } catch (e: Exception) {
            throw Exception("Error en la solicitud: ${e.message}")
        }
    }

}