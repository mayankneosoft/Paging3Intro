package com.paging3.sample.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.paging3.sample.paging_portion.PostDataSource
import com.paging3.sample.retrofit.ApiService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val apiService: ApiService) {


    fun getAllquotes() =
        Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100),
            pagingSourceFactory = {
                PostDataSource(apiService)
            }
        ).liveData
}