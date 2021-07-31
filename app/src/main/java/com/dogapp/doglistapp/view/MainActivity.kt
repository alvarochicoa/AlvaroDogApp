package com.dogapp.doglistapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogapp.doglistapp.BreedAdapter
import com.dogapp.doglistapp.databinding.ActivityMainBinding
import com.dogapp.doglistapp.model.BreedModel
import com.dogapp.doglistapp.viewmodel.BreedViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val breedViewModel : BreedViewModel by viewModels()
    private val breedsList = mutableListOf<BreedModel>()
    private lateinit var adapter: BreedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        breedViewModel.getAllBreeds()

        breedViewModel.breedModel.observe(this, Observer {
            binding.rvBreeds.adapter = BreedAdapter(it)
        })
    }

    private fun initRecyclerView() {
        adapter = BreedAdapter(breedsList)
        binding.rvBreeds.layoutManager = LinearLayoutManager(this)
        binding.rvBreeds.adapter = adapter
    }

}
