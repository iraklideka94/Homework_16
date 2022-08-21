package com.example.homework_16.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.homework_16.repository.Repository
import com.example.homework_16.paging.UserSource

class MainViewModel: ViewModel() {

    fun getInfo() = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = { UserSource(Repository()) }
    ).flow

}