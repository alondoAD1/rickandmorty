package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.Result

interface HomeRepository {
    suspend fun getCharacters(): List<Result>?
}