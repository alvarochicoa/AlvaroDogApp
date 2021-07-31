package com.dogapp.doglistapp

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Response

interface APIDogService {
    @GET
    suspend fun getAllDogs(@Url url: String): Response<DogResponse>
}