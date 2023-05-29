package com.example.androidapplicationtask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidapplicationtask.model.AyaatData

@Database(entities = [AyaatData::class], version = 1)
abstract class quranDb: RoomDatabase() {

    abstract fun qurandao() : QuranDao

}