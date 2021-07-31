package com.dogapp.doglistapp.data.network

import com.dogapp.doglistapp.core.RetrofitHelper
import com.dogapp.doglistapp.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getListDog(breed:String):List<DogModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(DogApiClient::class.java).getAllDogs("$breed/images")
            var listDogs:MutableList<DogModel> = mutableListOf()
            val images = response?.body()?.dogs ?: emptyList()
            images.forEach {
                listDogs.add(DogModel(it))
            }
            listDogs
        }
    }
}