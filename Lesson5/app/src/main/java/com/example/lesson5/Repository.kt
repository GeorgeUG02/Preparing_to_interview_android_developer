package com.example.lesson5

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repository {
    suspend fun createRetrofit():RedditApi{
        return Retrofit.Builder().baseUrl("https://reddit.com").addCallAdapterFactory(CoroutineCallAdapterFactory()).addConverterFactory(GsonConverterFactory.create()).build().create(RedditApi::class.java)
    }
    suspend fun getData():Posts{
        val redditApi = createRetrofit()
        val posts = redditApi.getPosts().await()
        return posts
    }
}