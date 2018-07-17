package com.example.papyrus.retrofitforandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_internal_page.*

class InternalPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_page)

        val bundle: Bundle = intent.extras
        var desbnd:String = bundle.getString("des_name")
        val titlebnd:String= bundle.getString("title_name")
        val imagebnd:String= bundle.getString("image_name")

        title_internal_page.text=titlebnd
        des_internal_page.text= desbnd
        Glide.with(this).load(imagebnd).into(image_internal_page)

    }

}
