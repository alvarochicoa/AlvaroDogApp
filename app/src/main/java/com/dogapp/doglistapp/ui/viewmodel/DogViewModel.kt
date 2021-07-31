package com.dogapp.doglistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dogapp.doglistapp.data.model.DogModel
import com.dogapp.doglistapp.domain.GetDogsUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel(){

    val dogModel = MutableLiveData<List<DogModel>>()
    val isLoading = MutableLiveData<Boolean>()

    var getDogsUSeCase = GetDogsUseCase()

    fun setAllImagesDogs(listDogs: List<DogModel>){
        dogModel.postValue(listDogs)
    }

    fun onCreate(breed:String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDogsUSeCase(breed)
            dogModel.postValue(result)
            isLoading.postValue(false)
        }
    }

}