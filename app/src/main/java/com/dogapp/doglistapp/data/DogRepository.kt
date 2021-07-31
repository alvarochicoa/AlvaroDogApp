package com.dogapp.doglistapp.data

import com.dogapp.doglistapp.data.model.DogModel
import com.dogapp.doglistapp.data.network.DogService

class DogRepository {

    private val api = DogService()

    suspend fun getAllDogs(breed:String):List<DogModel> = api.getListDog(breed)
}