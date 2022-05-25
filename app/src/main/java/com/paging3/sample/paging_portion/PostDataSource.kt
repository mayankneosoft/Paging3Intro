package com.paging3.sample.paging_portion

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.paging3.sample.models.Data
import com.paging3.sample.retrofit.ApiService

class PostDataSource(val apiService: ApiService) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorpos ->
            val anchorpage = state.closestPageToPosition(anchorpos)
            anchorpage?.prevKey?.plus(1)?:anchorpage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {

        return try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getQuotes(currentLoadingPageKey)


            return LoadResult.Page(
                data = response.results,
                prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1,
                nextKey = if (currentLoadingPageKey == response.totalPages) null else currentLoadingPageKey - 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}