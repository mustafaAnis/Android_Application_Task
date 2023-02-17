package com.example.androidapplicationtask

import android.app.Application
import android.content.Context
import androidx.room.Room

class ApplicationClass: Application() {



    companion object{
        @Volatile
        lateinit var database : quranDb

    }




    override fun onCreate() {
        getDatabase(this)
        super.onCreate()
    }
    fun getDatabase(context: Context):quranDb{
        if (database == null)
        {
            synchronized(this){
                database = Room.databaseBuilder(context.applicationContext,quranDb::class.java,"quranDb.db").createFromAsset("quranDb.db").build()
            }
        }
        return database!!
    }









}