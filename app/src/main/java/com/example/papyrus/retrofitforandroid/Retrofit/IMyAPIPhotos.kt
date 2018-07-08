package com.example.papyrus.retrofitforandroid.Retrofit

import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import retrofit2.http.GET
import retrofit2.http.Query

interface IMyAPIPhotos {
    @GET("get_posts")
    fun postsPhoto(@Query("page") page: Int): io.reactivex.Observable<PostWithPhotos>


}