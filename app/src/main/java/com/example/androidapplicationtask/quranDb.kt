package com.example.androidapplicationtask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AyaatData::class], version = 1)
abstract class quranDb: RoomDatabase() {

    abstract fun qurandao() : QuranDao

}