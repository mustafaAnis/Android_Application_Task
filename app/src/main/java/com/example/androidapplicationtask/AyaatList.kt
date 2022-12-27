package com.example.androidapplicationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AyaatList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var database: quranDb
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayaat_list)

        database = Room.databaseBuilder(applicationContext,quranDb::class.java,"quranDb.db").createFromAsset("quranDb.db").build()

        val a = database.qurandao().getAyat()
    }



    fun getData(view: View) {



    }
}