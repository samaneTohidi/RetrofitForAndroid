package com.example.papyrus.retrofitforandroid.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.postphoto_layout.view.*

class PostViewHolderPhotos (itemViewPhoto:View):RecyclerView.ViewHolder(itemViewPhoto){

    val title_txt_photo = itemViewPhoto.txt_title_photo
    val id_txt = itemViewPhoto.txt_id
    val photos_thumbnail = itemViewPhoto.image_thumbnail

}