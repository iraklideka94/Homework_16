package com.example.homework_16.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitInstance {

    private const val BASE_URL = "https://reqres.in/"

    suspend fun getUserApi() : ApiClient =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)

}