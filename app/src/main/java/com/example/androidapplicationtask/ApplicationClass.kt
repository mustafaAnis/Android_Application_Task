package com.example.androidapplicationtask

import android.app.Application
import android.content.Context
import androidx.room.Room
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass: Application() {



    companion object{
        @Volatile
        lateinit  var database : quranDb
        lateinit  var retrofitData : Retrofit

    }




    override fun onCreate() {
        val BASE_URL = "https://api.jsonserve.com"
        setRetrofit(BASE_URL)
        setDatabase(this)
        super.onCreate()
    }
    private fun setDatabase(context: Context){
            synchronized(this){
                database = Room.databaseBuilder(context.applicationContext,quranDb::class.java,"quranDb.db").createFromAsset("quranDb.db").build()
            }
        }
    private fun setRetrofit(url : String){
    retrofitData = Retrofit.Builder().baseUrl(url).addConverterFactory(
        GsonConverterFactory.create()).build()
    }




    }









