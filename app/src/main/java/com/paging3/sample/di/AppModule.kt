package com.paging3.sample.di

import com.paging3.sample.retrofit.ApiService
import com.paging3.sample.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideFoodAPI(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    /* @Singleton
     @Provides
     fun getRetrofit(): Retrofit {
         return Retrofit.Builder()
             .baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create()).build()
     }


     @Singleton
     @Provides
     fun getApi(retrofit: Retrofit): ApiService {
         return retrofit.create(ApiService::class.java)
     }*/
}