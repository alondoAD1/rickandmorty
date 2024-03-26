package com.example.myapplication.data.repository

import com.example.myapplication.data.model.Result
import com.example.myapplication.Modules.Home.data.datasource.remote.HomeDataSource
import com.example.myapplication.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val dataSource: HomeDataSource):
    HomeRepository {

    override suspend fun getCharacters(): List<Result>? {
        return dataSource.getCharacters()
    }

}