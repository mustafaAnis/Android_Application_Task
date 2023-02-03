package com.example.androidapplicationtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FlashesRecyclerAdapter(val flashes:List<Post>, val context: Flashes): RecyclerView.Adapter<FlahsesViewHolder>() {
    var url = "https://islam360.app/islam360/posts/image/urdu/"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlahsesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.flashes_list_view,parent,false)
        return FlahsesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flashes.size
    }

    override fun onBindViewHolder(holder: FlahsesViewHolder, position: Int) {

        Glide.with(context).load(url+flashes[position].path).into(holder.imgView)

    }


}

class FlahsesViewHolder(flashesView: View) :RecyclerView.ViewHolder(flashesView){
var imgView = flashesView.findViewById<ImageView>(R.id.flashesView)

}