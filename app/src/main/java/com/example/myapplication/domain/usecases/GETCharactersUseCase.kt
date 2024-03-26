package com.example.myapplication.domain.usecases

import com.example.myapplication.data.model.Result
import com.example.myapplication.domain.repository.HomeRepository
import javax.inject.Inject

class GETCharactersUseCase @Inject constructor(private val repository: HomeRepository) {

    suspend operator fun invoke(): List<Result>? {
        return repository.getCharacters()
    }

}