package com.example.myapplication.Service

import retrofit2.Retrofit
import javax.inject.Inject

class NetworkManager @Inject constructor(
    val retrofit: Retrofit
) {
    // Función genérica para crear y obtener servicios de API
    inline fun <reified T> createApiService(): T {
        return retrofit.create(T::class.java)
    }
}