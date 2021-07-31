package com.dogapp.doglistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dogapp.doglistapp.data.model.BreedModel
import com.dogapp.doglistapp.data.database.BreedProvider

class BreedViewModel : ViewModel(){

    val breedModel = MutableLiveData<List<BreedModel>>()

    fun getAllBreeds(){
        val breeds = BreedProvider.getAllBreedList()
        breedModel.postValue(breeds)
    }
}