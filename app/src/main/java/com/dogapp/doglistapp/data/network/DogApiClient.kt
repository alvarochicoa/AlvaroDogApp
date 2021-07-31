package com.dogapp.doglistapp.data.network

import com.dogapp.doglistapp.data.DogResponse
import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Response

interface DogApiClient {
    @GET
    suspend fun getAllDogs(@Url url: String): Response<DogResponse>
}