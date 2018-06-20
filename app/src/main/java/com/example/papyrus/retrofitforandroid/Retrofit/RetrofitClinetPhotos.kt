package com.example.papyrus.retrofitforandroid.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClinetPhotos {
    private var ourInstance: Retrofit? = null
    val instance:Retrofit
        get() {
            if (RetrofitClinetPhotos.ourInstance == null){
                RetrofitClinetPhotos.ourInstance = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

            }
            return RetrofitClinetPhotos.ourInstance!!
        }
}