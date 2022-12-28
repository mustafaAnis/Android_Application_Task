package com.example.androidapplicationtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AyaatData::class], version = 1)
abstract class quranDb: RoomDatabase() {

    abstract fun qurandao() : QuranDao

    companion object{
        @Volatile
        private var INSTANCE : quranDb? = null
        fun getDatabase(context: Context):quranDb{
            if (INSTANCE == null)
            {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,quranDb::class.java,"quranDb.db").createFromAsset("quranDb.db").build()
                }
            }
            return INSTANCE!!
        }
    }


}