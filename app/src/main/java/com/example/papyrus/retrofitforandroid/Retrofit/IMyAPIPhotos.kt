package com.example.papyrus.retrofitforandroid.Retrofit

import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import retrofit2.http.GET

interface IMyAPIPhotos {
    @get:GET("photos")
    val postsPhoto:io.reactivex.Observable<List<PostWithPhotos>>
}