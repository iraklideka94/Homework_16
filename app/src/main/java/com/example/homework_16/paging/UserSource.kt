package com.example.homework_16.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework_16.model.DataX
import com.example.homework_16.repository.Repository


class UserSource(
    private val repository: Repository
) : PagingSource<Int, DataX.User>() {

    override fun getRefreshKey(state: PagingState<Int, DataX.User>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataX.User> {
        val page: Int = params.key ?: 1

        repository.getUserInfo(page)?.let {
            return LoadResult.Page(
                it.data ?: emptyList(),
                if (page > 1) page - 1 else null,
                if (page < it.totalPages!!) page + 1 else null
            )
        }

        return LoadResult.Error(Exception())

    }

}