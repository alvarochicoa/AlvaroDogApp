package com.dogapp.doglistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogapp.doglistapp.data.model.DogModel
import com.dogapp.doglistapp.data.provider.DogProvider

class DogViewModel : ViewModel(){

    val dogModel = MutableLiveData<List<DogModel>>()

    fun getAllDogs(){
        val dogs = DogProvider.getAllDogList()
        dogModel.postValue(dogs)
    }

    fun getAllImagesDogs(listDogs: List<DogModel>){
        dogModel.postValue(listDogs)
    }

}