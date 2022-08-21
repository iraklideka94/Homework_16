package com.example.homework_16.network

import com.example.homework_16.model.DataX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api/users?page=1")
    suspend fun getData(@Query("page") page: Int): Response<DataX>

}