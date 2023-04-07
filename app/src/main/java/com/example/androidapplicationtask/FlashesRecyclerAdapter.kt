package com.example.androidapplicationtask

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtask.databinding.FlashesListViewBinding

class FlashesRecyclerAdapter(val flashes: List<Post>, val context: Context) :
    RecyclerView.Adapter<FlashesRecyclerAdapter.FlahsesViewHolder>() {
    var url = "https://islam360.app/islam360/posts/image/urdu/"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlahsesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FlahsesViewHolder(DataBindingUtil.inflate(inflater,R.layout.flashes_list_view, parent, false))
    }

    override fun onBindViewHolder(holder: FlahsesViewHolder, position: Int) {
        val model = flashes[position]
        holder.bind(model)
    }


    override fun getItemCount(): Int {
        return flashes.size
    }


    class FlahsesViewHolder(val binding: FlashesListViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Post){
            binding.model = model

        }

    }
}
