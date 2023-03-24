package com.example.androidapplicationtask

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("setBookmarkImage")
fun ImageView.setBookmarkImage(flag: Int){


        if (flag != 1) {
            this.setImageResource(R.drawable.holo_bookmark)
        } else {
            this.setImageResource(R.drawable.solid_bookmark)
        }


}
@BindingAdapter("setFlashes")
fun ImageView.setFlashes(flashes : Post){
    val url = "https://islam360.app/islam360/posts/image/urdu/"

    Picasso.get().load(url + flashes.path)
        .placeholder(R.drawable.baseline_downloading_24).into(this)


}