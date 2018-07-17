package com.example.papyrus.retrofitforandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.papyrus.retrofitforandroid.Adapter.PostAdapter
import com.example.papyrus.retrofitforandroid.Adapter.PostAdapterPhotos
import com.example.papyrus.retrofitforandroid.Models.Post
import com.example.papyrus.retrofitforandroid.Models.PostOld
import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import com.example.papyrus.retrofitforandroid.Retrofit.IMyAPI
import com.example.papyrus.retrofitforandroid.Retrofit.IMyAPIPhotos
import com.example.papyrus.retrofitforandroid.Retrofit.RetrofitClinet
import com.example.papyrus.retrofitforandroid.Retrofit.RetrofitClinetPhotos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import com.example.papyrus.retrofitforandroid.R.id.recycler_posts_photos
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.list_main.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    var userPage:Int = 1
    internal lateinit var jsonApiPhotos: IMyAPIPhotos
    internal lateinit var jsonApi: IMyAPI
    internal var compositeDisposable = CompositeDisposable()
    internal var compositeDisposablePhoto = CompositeDisposable()
    internal lateinit var adapterPhoto: PostAdapterPhotos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolbar
        setSupportActionBar(toolbar)

        //drawer
        var toggle= ActionBarDrawerToggle(
                this, drawer_layout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)







        adapterPhoto = PostAdapterPhotos(this, ArrayList())
        recycler_posts_photos.adapter = adapterPhoto

//        Init API
        val retrofit = RetrofitClinet.instance
        jsonApi = retrofit.create(IMyAPI::class.java)

        val retrofitPhoto = RetrofitClinetPhotos.instance
        jsonApiPhotos = retrofitPhoto.create(IMyAPIPhotos::class.java)


//        View
        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager = LinearLayoutManager(this)
        var tet = LinearLayoutManager(this)
        recycler_posts_photos.setHasFixedSize(true)
        recycler_posts_photos.layoutManager = tet

        recycler_posts_photos.addOnScrollListener(object : EndlessRecyclerViewScrollListener(tet) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {

                var newTestPage = page + 1
                progressbar.visibility = View.VISIBLE

                fetchData(newTestPage)



            }


        })

        fetchData(userPage)

    }

    //    براي نمايش اطلاعات در تردهاي مختلف
    private fun fetchData(newPage:Int) {
        compositeDisposable.add(jsonApi.posts.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { posts -> displayData(posts) })
        compositeDisposablePhoto.add(jsonApiPhotos.postsPhoto(newPage).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { postsPhoto -> displayDataPhoto(postsPhoto) })


    }

    private fun displayDataPhoto(postsPhoto: PostWithPhotos?) {
        progressbar.visibility = View.GONE
        adapterPhoto.addMoreItem(postsPhoto!!.posts)


    }

    //    نمايش اطلاعات و وصل كردن ادابتور
    private fun displayData(posts: List<PostOld>?) {
        val adapter = PostAdapter(this, posts!!)
        recycler_posts.adapter = adapter

    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_1 -> {
                // Handle the camera action
            }
            R.id.nav_2 -> {

            }
            R.id.nav_3 -> {

            }
            R.id.nav_4 -> {

            }
            R.id.nav_5 -> {

            }
            R.id.nav_6 -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
