package com.dogapp.doglistapp.data.database

import com.dogapp.doglistapp.data.model.DogModel

class DogProvider {

    companion object {

        fun getAllDogList(): List<DogModel>{
            return dogs
        }

        private val dogs = listOf<DogModel>(
            DogModel("Perro 1"),
        )
    }
}