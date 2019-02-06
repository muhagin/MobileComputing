package com.arieharyana.dev.blackpink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        val name = intent.getStringExtra("MEMBER_NAME")
        val image = intent.getStringExtra("MEMBER_IMAGE")
        val bio = intent.getStringExtra("MEMBER_BIO")

        titleDetail.text = name
        contentDetail.text = bio
        Picasso.get().load(image).into(imageDetail)


    }
}