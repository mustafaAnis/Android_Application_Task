package com.example.androidapplicationtask

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("setBookmarkImage")
fun ImageView.setBookmarkImage(flag: Int){


        if (flag != 1) {
            this.setImageResource(R.drawable.holo_bookmark)
        } else {
            this.setImageResource(R.drawable.solid_bookmark)
        }


}