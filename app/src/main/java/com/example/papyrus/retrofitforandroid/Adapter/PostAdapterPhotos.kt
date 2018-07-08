package com.example.papyrus.retrofitforandroid.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.example.papyrus.retrofitforandroid.Models.PostWithPhotos
import com.example.papyrus.retrofitforandroid.R
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import android.graphics.Bitmap
import android.text.Html
import com.bumptech.glide.Glide


class PostAdapterPhotos(internal var context: Context, internal var postListWithPhoto: PostWithPhotos) : RecyclerView.Adapter<PostViewHolderPhotos>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderPhotos {
        val itemViewPhoto = LayoutInflater.from(parent.context).inflate(R.layout.postphoto_layout, parent, false)

        return PostViewHolderPhotos(itemViewPhoto)
    }

    override fun getItemCount(): Int {
        return postListWithPhoto.posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolderPhotos, position: Int) {
        holder.id_txt.text = postListWithPhoto.posts[position].id.toString()
        holder.title_txt_photo.text = postListWithPhoto.posts[position].title

        holder.photos_des_photo.setText(Html.fromHtml(Html.fromHtml(postListWithPhoto.posts[position].content).toString()))

        val iv: ImageView = holder.photos_thumbnail
        val fileUrl: String = postListWithPhoto.posts[position].thumbnail
        Glide.with(context).load(fileUrl).into(iv)



    }
}