package com.dogapp.doglistapp.domain

import com.dogapp.doglistapp.data.DogRepository
import com.dogapp.doglistapp.data.model.DogModel

class GetDogsUseCase {

    private val repository = DogRepository()

    suspend operator fun invoke(breed:String): List<DogModel> = repository.getAllDogs(breed)
}