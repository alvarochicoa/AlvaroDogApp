package com.dogapp.doglistapp.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogapp.doglistapp.APIDogService
import com.dogapp.doglistapp.DogAdapter
import com.dogapp.doglistapp.databinding.DogActivityBinding
import com.dogapp.doglistapp.model.DogModel
import com.dogapp.doglistapp.viewmodel.DogViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogActivity : AppCompatActivity(){

    private lateinit var binding : DogActivityBinding
    private val dogViewModel : DogViewModel by viewModels()
    private val dogList = mutableListOf<DogModel>()
    private lateinit var adapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DogActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        dogViewModel.getAllDogs()
        searchBreeds(intent.getStringExtra("breed"))

        dogViewModel.dogModel.observe(this, Observer {
            binding.rvDogs.adapter = DogAdapter(it)
        })
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogList)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private fun searchBreeds(breed: String?){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIDogService::class.java).getAllDogs("$breed/images")
            val dogs = call.body()
            var listDogs:MutableList<DogModel> = mutableListOf()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images = dogs?.dogs ?: emptyList()
                    images.forEach {
                        listDogs.add(DogModel(it))
                    }
                    dogViewModel.getAllImagesDogs(listDogs)
                } else {}
            }
        }
    }

}
