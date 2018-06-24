package com.example.papyrus.retrofitforandroid.Retrofit

import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import retrofit2.http.GET

interface IMyAPIPhotos {
    @get:GET("get_posts")
    val postsPhoto:io.reactivex.Observable<List<PostWithPhotos>>
}