package com.example.papyrus.retrofitforandroid.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.papyrus.retrofitforandroid.Models.PostOld
import com.example.papyrus.retrofitforandroid.R

class PostAdapter(internal var context: Context, internal var postOldList: List<PostOld>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_layout,parent,false)

        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postOldList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_author.text = postOldList[position].userId.toString()
        holder.txt_title.text = postOldList[position].title
        holder.txt_content.text = StringBuilder(postOldList[position].body.substring(0,20)).append("...").toString()

    }


}