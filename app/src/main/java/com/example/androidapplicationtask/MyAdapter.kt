package com.example.androidapplicationtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(val surah: List<String>) : Adapter<MyAdapter.MyViewHolder>() {   //some changes happen here if any error comes then check here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.syrahName.text = surah[position]
    }

    override fun getItemCount(): Int {
        return surah.size
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var syrahName = itemView.findViewById<TextView>(R.id.surahName)
        var ayatNo = itemView.findViewById<TextView>(R.id.ayatNo)

    }
}

