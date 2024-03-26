package com.example.myapplication.data.repository

import com.example.myapplication.Modules.Home.data.datasource.remote.HomeDataSource
import com.example.myapplication.domain.repository.HomeRepository
import com.example.myapplication.Service.NetworkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeRepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(dataSource: HomeDataSource): HomeRepository {
        return HomeRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideHomeDataSource(networkManager: NetworkManager): HomeDataSource {
        return HomeDataSource(networkManager)
    }

}