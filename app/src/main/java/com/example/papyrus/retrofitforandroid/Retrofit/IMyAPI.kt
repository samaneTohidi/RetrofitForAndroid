package com.example.papyrus.retrofitforandroid.Retrofit

import com.example.papyrus.retrofitforandroid.Models.PostOld
import retrofit2.http.GET

interface IMyAPI {
    @get:GET("posts")
    val posts:io.reactivex.Observable<List<PostOld>>

}