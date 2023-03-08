package com.example.androidapplicationtask

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FlashesRecyclerAdapter(val flashes: List<Post>, val context: Context) :
    RecyclerView.Adapter<FlashesRecyclerAdapter.FlahsesViewHolder>() {
    var url = "https://islam360.app/islam360/posts/image/urdu/"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlahsesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.flashes_list_view, parent, false)
        return FlahsesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlahsesViewHolder, position: Int) {


        Log.d("recycle", url + flashes[position].path)
        Picasso.get().load(url + flashes[position].path).into(holder.imgView)

    }


    override fun getItemCount(): Int {
        return flashes.size
    }


    class FlahsesViewHolder(flashesView: View) : RecyclerView.ViewHolder(flashesView) {
        var imgView = flashesView.findViewById<ImageView>(R.id.flashesImageView)

    }
}

