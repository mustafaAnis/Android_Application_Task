package com.example.androidapplicationtask.applicationClass

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.androidapplicationtask.api.FlashesAPI
import com.example.androidapplicationtask.db.quranDb
import com.example.androidapplicationtask.repository.FlashesRepo
import com.example.androidapplicationtask.repository.QuranRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    lateinit var quranRepo: QuranRepo
    lateinit var flashesRepo: FlashesRepo


    companion object {
        @Volatile
        lateinit var database: quranDb
        lateinit var retrofitData: Retrofit
    }


    override fun onCreate() {
        val BASE_URL = "https://api.jsonserve.com"
        setRetrofit(BASE_URL)
        setDatabase(this)
        initialize()
        super.onCreate()
    }

    private fun initialize() {
        val dao = database.qurandao()
        quranRepo = QuranRepo(dao)

        val flashesAPI = retrofitData.create(FlashesAPI::class.java)
        flashesRepo = FlashesRepo(flashesAPI)
    }

    private fun setDatabase(context: Context) {
        synchronized(this) {
            database =
                Room.databaseBuilder(context.applicationContext, quranDb::class.java, "quranDb.db")
                    .createFromAsset("quranDb.db").build()
        }
    }

    private fun setRetrofit(url: String) {
        retrofitData = Retrofit.Builder().baseUrl(url).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }


}









