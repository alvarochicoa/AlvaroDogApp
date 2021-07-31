package com.dogapp.doglistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dogapp.doglistapp.data.model.DogModel
import com.dogapp.doglistapp.data.database.DogProvider
import com.dogapp.doglistapp.domain.GetDogsUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel(){

    val dogModel = MutableLiveData<List<DogModel>>()

    var getDogsUSeCase = GetDogsUseCase()

    fun getAllDogs(){
        val dogs = DogProvider.getAllDogList()
        dogModel.postValue(dogs)
    }

    fun setAllImagesDogs(listDogs: List<DogModel>){
        dogModel.postValue(listDogs)
    }

    fun onCreate(breed:String) {
        viewModelScope.launch {
            val result = getDogsUSeCase(breed)
            dogModel.postValue(result)
        }
    }

}