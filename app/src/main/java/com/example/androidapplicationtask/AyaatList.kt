package com.example.androidapplicationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AyaatList : AppCompatActivity() {
    lateinit var database: quranDb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayaat_list)

        database = quranDb.getDatabase(this)


    }



    fun getData(view: View) {

        GlobalScope.launch {
            val dataList: List<AyaatData> = database.qurandao().getAyat()
            Log.d("checking database", dataList.size.toString())

        }

    }




}