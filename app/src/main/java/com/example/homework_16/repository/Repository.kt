package com.example.homework_16.repository

import com.example.homework_16.model.DataX
import com.example.homework_16.network.RetrofitInstance

class Repository {

    suspend fun getUserInfo(page: Int): DataX? {
        val response = RetrofitInstance.getUserApi().getData(page)
        return if (response.isSuccessful && response.body() != null)
            response.body()!!
        else null
    }

}