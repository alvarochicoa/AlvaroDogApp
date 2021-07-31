package com.dogapp.doglistapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dogapp.doglistapp.databinding.ItemDogBinding
import com.dogapp.doglistapp.data.model.DogModel

class DogAdapter(val dogs: List<DogModel>) : RecyclerView.Adapter<DogAdapter.DogViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDogBinding.inflate(layoutInflater, parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item:DogModel = dogs[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dogs.size

    class DogViewHolder(var binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(dog:DogModel){
            Glide.with(binding.root).load(dog.dog).into(binding.ivDog)
            dog.dog.forEach {
                Log.v("DOGS_LIST", dog.dog)
            }
        }
    }
}
