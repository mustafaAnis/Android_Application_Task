package com.example.androidapplicationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class quran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        val surah = listOf<String>("Al-Fatihah","Al-Bakarah","Aali'imran","An-Nisa","Al-Ma'idah","Al-An'am","Al-Fatihah","Al-Bakarah","Aali'imran","An-Nisa","Al-Ma'idah","Al-An'am","Al-Fatihah","Al-Bakarah","Aali'imran","An-Nisa","Al-Ma'idah","Al-An'am")
        val surahList = findViewById<RecyclerView>(R.id.surahList)
        surahList.adapter = MyAdapter(surah)
        surahList.layoutManager = LinearLayoutManager(this)
    }
}