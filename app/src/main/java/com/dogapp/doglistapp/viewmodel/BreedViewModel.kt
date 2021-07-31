package com.dogapp.doglistapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogapp.doglistapp.model.BreedModel
import com.dogapp.doglistapp.model.BreedProvider

class BreedViewModel : ViewModel(){

    val breedModel = MutableLiveData<List<BreedModel>>()

    fun getAllBreeds(){
        val breeds = BreedProvider.getAllBreedList()
        breedModel.postValue(breeds)
    }
}