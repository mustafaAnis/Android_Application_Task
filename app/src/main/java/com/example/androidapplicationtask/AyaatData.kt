package com.example.androidapplicationtask

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text

@Entity(tableName = "tbl_QuranComplete")
data class AyaatData(
    @PrimaryKey
    val id: Int,
     val surat_id: Int,
     val para_id: Int,
     val ayat_number: Int,
     val translation_urdu: String?,
    val is_bookmarked : Int?,
    val arabic: String
    )
