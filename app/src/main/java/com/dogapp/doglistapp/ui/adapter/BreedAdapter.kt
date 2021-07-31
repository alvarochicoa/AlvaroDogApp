package com.dogapp.doglistapp.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogapp.doglistapp.databinding.ItemBreedBinding
import com.dogapp.doglistapp.data.model.BreedModel
import com.dogapp.doglistapp.ui.view.DogActivity

class BreedAdapter(val breeds: List<BreedModel>) : RecyclerView.Adapter<BreedAdapter.BreedViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
        return BreedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val item:BreedModel = breeds[position]
        holder.bind(item)
        holder.binding.cvBreed.setOnClickListener {
            val intent = Intent(it.context, DogActivity::class.java).apply {
              putExtra("breed",breeds[position].breed)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = breeds.size

    class BreedViewHolder(var binding: ItemBreedBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(breed:BreedModel){
            binding.tvBreed.text = breed.breed
        }
    }
}