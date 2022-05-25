package com.paging3.sample.retrofit

import com.paging3.sample.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int) :QuoteList
}