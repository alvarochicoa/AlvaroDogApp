package com.dogapp.doglistapp.model

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