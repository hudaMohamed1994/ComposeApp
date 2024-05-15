package com.example.composeapp.Data.Remote

import com.example.composeapp.Data.model.Posts
import retrofit2.http.GET

interface RetrofitApi {
    @GET("posts")
    suspend fun getPosts() : List<Posts>

}