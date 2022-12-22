package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SurahRecycleAdapter(val surah: List<Surah>, val context : Context ) : Adapter<SurahRecycleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.surah_item_view, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.surahNo.text = surah[position].surahNo.toString()
        holder.surahName.text = surah[position].surahName
        holder.ayatNo.text = "Ayaat :" + surah[position].totalAyat.toString()
        holder.surahCard.setOnClickListener(){
            
            if(position == 0){
            val intent = Intent(context,AyaatList::class.java)
            context.startActivity(intent)
            }
            else{
                Toast.makeText(context, "No Data Available ", Toast.LENGTH_SHORT).show()
            }

        }
    }


    override fun getItemCount(): Int {
        return surah.size
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var surahCard = itemView.findViewById<CardView>(R.id.surahCard)
        var surahNo = itemView.findViewById<TextView>(R.id.surahNo)
        var surahName = itemView.findViewById<TextView>(R.id.surahName)
        var ayatNo = itemView.findViewById<TextView>(R.id.ayatNo)

    }
}

