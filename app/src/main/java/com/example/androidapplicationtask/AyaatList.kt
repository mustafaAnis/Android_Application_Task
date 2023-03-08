package com.example.androidapplicationtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class AyaatList : AppCompatActivity() {
    lateinit var database: quranDb
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayaat_list)
        val ayaatView = findViewById<RecyclerView>(R.id.ayaatView)

        database = quranDb.getDatabase(this)
        database.qurandao().getAyat().observe(this) {


            ayaatView.adapter = AyaatRecyclerAdapter(it, this)
            ayaatView.layoutManager = LinearLayoutManager(this)

        }

    }

}
