package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AyaatRecyclerAdapter(
    val ayaat: List<AyaatData>,
    val onItemClickListenerForAyaat: OnItemClickListenerForAyaat,
    val context: Context
) : RecyclerView.Adapter<AyaatRecyclerAdapter.AyaatViewHolder>() {
    lateinit var database: quranDb
    val ayatObject = lists.getAyatList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyaatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ayat_item_view, parent, false)
        return AyaatViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AyaatViewHolder, position: Int) {

        holder.arabic.text = ayaat[position].arabic.toString()
        holder.translation.text = ayaat[position].translation_urdu.toString()
        holder.surahAyatNo.text =
            ayaat[position].surat_id.toString() + "." + ayaat[position].ayat_number.toString()


        holder.bookmark.setOnClickListener {
            onItemClickListenerForAyaat.onItemClickBookmark(position, ayaat[position])

        }
        holder.flashes.setOnClickListener() {
            onItemClickListenerForAyaat.onItemClickFlash()
        }


        if (ayaat[position].is_bookmarked == 0) {
            holder.bookmark.setImageResource(R.drawable.holo_bookmark)
        } else {
            holder.bookmark.setImageResource(R.drawable.solid_bookmark)
        }
    }

    override fun getItemCount(): Int {
        return ayaat.size
    }

    class AyaatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var arabic = itemView.findViewById<TextView>(R.id.arabic)
        var translation = itemView.findViewById<TextView>(R.id.translation)
        var surahAyatNo = itemView.findViewById<TextView>(R.id.surahAyatNo)
        var bookmark = itemView.findViewById<ImageView>(R.id.bookmark)
        var flashes = itemView.findViewById<ImageView>(R.id.flashes)
    }
}




