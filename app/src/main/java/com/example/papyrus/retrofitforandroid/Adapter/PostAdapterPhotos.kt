package com.example.papyrus.retrofitforandroid.Adapter

import android.content.Context
import android.content.Intent
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
import com.example.papyrus.retrofitforandroid.InternalPage
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
        var texid= postListWithPhoto[position].id.toString()
        var title = postListWithPhoto[position].title
        var des=  Html.fromHtml(Html.fromHtml(postListWithPhoto[position].content).toString()).toString()
        holder.id_txt.text = texid
        holder.title_txt_photo.text = title
        holder.photos_des_photo.text =des
        val iv: ImageView = holder.photos_thumbnail
        val fileUrl: String = postListWithPhoto[position].thumbnail
        Glide.with(context).load(fileUrl).into(iv)

        //intent
       holder.cardview.setOnClickListener {
           var intent= Intent(context, InternalPage::class.java)
           intent.putExtra("text_name", texid)
           intent.putExtra("title_name", title)
           intent.putExtra("image_name", fileUrl)
           intent.putExtra("des_name", des)
           context.startActivity(intent) }







    }

    fun addMoreItem(posts: List<Post>) {
        postListWithPhoto.addAll(posts)
        this.notifyDataSetChanged()
    }
}