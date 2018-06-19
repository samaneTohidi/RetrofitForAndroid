package com.example.papyrus.retrofitforandroid.Retrofit

import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object RetrofitClinet {
    private var ourInstance:Retrofit? = null

    val instance:Retrofit
        get() {
            if (ourInstance == null){
                ourInstance = Builder().baseUrl("https://jsonplaceholder.typicode.com/").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

            }
            return ourInstance!!
        }
}