package com.example.papyrus.retrofitforandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.example.papyrus.retrofitforandroid.Adapter.PostAdapter
import com.example.papyrus.retrofitforandroid.Adapter.PostAdapterPhotos
import com.example.papyrus.retrofitforandroid.Models.Post
import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import com.example.papyrus.retrofitforandroid.Retrofit.IMyAPI
import com.example.papyrus.retrofitforandroid.Retrofit.IMyAPIPhotos
import com.example.papyrus.retrofitforandroid.Retrofit.RetrofitClinet
import com.example.papyrus.retrofitforandroid.Retrofit.RetrofitClinetPhotos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApiPhotos: IMyAPIPhotos
    internal lateinit var jsonApi: IMyAPI
    internal var compositeDisposable = CompositeDisposable()
    internal var compositeDisposablePhoto = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Init API
        val retrofit = RetrofitClinet.instance
        jsonApi = retrofit.create(IMyAPI::class.java)

        val retrofitPhoto = RetrofitClinetPhotos.instance
        jsonApiPhotos = retrofitPhoto.create(IMyAPIPhotos::class.java)


//        View
        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager = LinearLayoutManager(this)

        recycler_posts_photos.setHasFixedSize(true)
        recycler_posts_photos.layoutManager = LinearLayoutManager(this)
        fetchData()

    }

    //    براي نمايش اطلاعات در تردهاي مختلف
    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { posts -> displayData(posts) })
        compositeDisposablePhoto.add(jsonApiPhotos.postsPhoto.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { postsPhoto -> displayDataPhoto(postsPhoto) })


    }

    private fun displayDataPhoto(postsPhoto: List<PostWithPhotos>?) {
        val adapterPhoto = PostAdapterPhotos(this, postsPhoto!!)
        recycler_posts_photos.adapter = adapterPhoto

    }

    //    نمايش اطلاعات و وصل كردن ادابتور
    private fun displayData(posts: List<Post>?) {
        val adapter = PostAdapter(this, posts!!)
        recycler_posts.adapter = adapter

    }
}
