package com.example.androidapplicationtask

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_QuranComplete")
data class tbl_QuranComplete(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
     val surat_id: Int,
     val para_id: Int,
     val ayat_number: Int,
     val translation_urdu: String?,
     val arabic:String,
     val is_Bookmarked : Int?)
