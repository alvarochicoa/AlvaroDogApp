package com.dogapp.doglistapp

import com.dogapp.doglistapp.model.DogModel
import com.google.gson.annotations.SerializedName

data class DogResponse(
        @SerializedName("message") var dogs: List<String>,
        @SerializedName("status") var status: String
)