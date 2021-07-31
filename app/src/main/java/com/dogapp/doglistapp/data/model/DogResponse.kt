package com.dogapp.doglistapp.data

import com.google.gson.annotations.SerializedName

data class DogResponse(
        @SerializedName("message") var dogs: List<String>,
        @SerializedName("status") var status: String
)