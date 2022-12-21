package com.example.androidapplicationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class quran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        val surahObject = lists.getSurahList()



        val surahList = findViewById<RecyclerView>(R.id.surahList)
        surahList.adapter = MyAdapter(surahObject)
        surahList.layoutManager = LinearLayoutManager(this)


    }
}