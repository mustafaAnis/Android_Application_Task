package com.example.androidapplicationtask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_QuranComplete")
data class AyaatData(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
     val surahNo: Int,
     val ayatNo: Int,
     val paraId: Int,
     val translation: String ,
     val arabic:String,
     val isBookmarked : Int)
