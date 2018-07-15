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
import com.example.papyrus.retrofitforandroid.Models.Post


class PostAdapterPhotos(internal var context: Context, internal var postListWithPhoto: ArrayList<Post>) : RecyclerView.Adapter<PostViewHolderPhotos>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderPhotos {
        val itemViewPhoto = LayoutInflater.from(parent.context).inflate(R.layout.postphoto_layout, parent, false)

        return PostViewHolderPhotos(itemViewPhoto)
    }

    override fun getItemCount(): Int {
        return postListWithPhoto.size
    }

    override fun onBindViewHolder(holder: PostViewHolderPhotos, position: Int) {
        holder.id_txt.text = postListWithPhoto[position].id.toString()
        holder.title_txt_photo.text = postListWithPhoto[position].title

        holder.photos_des_photo.setText(Html.fromHtml(Html.fromHtml(postListWithPhoto[position].content).toString()))

        val iv: ImageView = holder.photos_thumbnail
        val fileUrl: String = postListWithPhoto[position].thumbnail
        Glide.with(context).load(fileUrl).into(iv)



    }

    fun addMoreItem(posts: List<Post>) {
        postListWithPhoto.addAll(posts)
        this.notifyDataSetChanged()
    }
}