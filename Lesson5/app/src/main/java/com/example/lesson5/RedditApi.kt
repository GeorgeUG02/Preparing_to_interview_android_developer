package com.example.lesson5

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RedditApi {
     @GET("/r/aww/hot.json")
     fun getPosts(): Deferred<Posts>
}