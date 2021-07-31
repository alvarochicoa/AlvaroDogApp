package com.dogapp.doglistapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogapp.doglistapp.data.network.DogApiClient
import com.dogapp.doglistapp.ui.adapter.DogAdapter
import com.dogapp.doglistapp.databinding.DogActivityBinding
import com.dogapp.doglistapp.data.model.DogModel
import com.dogapp.doglistapp.ui.viewmodel.DogViewModel
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
        dogViewModel.onCreate(intent.getStringExtra("breed")!!)

        dogViewModel.dogModel.observe(this, Observer {
            binding.rvDogs.adapter = DogAdapter(it)
        })
        dogViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.ivArrowBack.setOnClickListener(){
           finish()
        }
        binding.tvBackText.setOnClickListener(){
            finish()
        }
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogList)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }
}
