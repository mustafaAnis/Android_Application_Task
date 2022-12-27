package com.example.androidapplicationtask

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [tbl_QuranComplete::class], version = 1)
abstract class quranDb: RoomDatabase() {

    abstract fun qurandao() : QuranDao
}