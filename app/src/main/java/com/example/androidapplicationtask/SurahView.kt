package com.example.androidapplicationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SurahView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        val surahObject = lists.getSurahList()

        surahObject.add(Surah(1,"Al-Fatihah",7))
        surahObject.add(Surah(2,"Al-Bakarah",286))
        surahObject.add(Surah(3,"Aali'imran",200))
        surahObject.add(Surah(4,"An-Nisa",176))
        surahObject.add(Surah(5,"Al-Ma'idah",120))
        surahObject.add(Surah(6,"Al-An'am",165))
        surahObject.add(Surah(7,"Al-Aeraaf",206))
        surahObject.add(Surah(8,"Al-Anfaal",75))



        val surahList = findViewById<RecyclerView>(R.id.surahList)
        surahList.adapter = SurahRecycleAdapter(surahObject,this)
        surahList.layoutManager = LinearLayoutManager(this)


    }
}
