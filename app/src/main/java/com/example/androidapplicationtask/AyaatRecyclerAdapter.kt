package com.example.androidapplicationtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class AyaatRecyclerAdapter(val ayaat: List<AyaatData>, val context: Context): RecyclerView.Adapter<AyaatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyaatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ayat_item_view, parent, false)
        return AyaatViewHolder(view)
    }

    override fun onBindViewHolder(holder: AyaatViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}


class AyaatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
}