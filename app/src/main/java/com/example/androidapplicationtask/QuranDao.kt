package com.example.androidapplicationtask

import androidx.room.Dao

@Dao
interface QuranDao {


    fun updateAyat()

    fun getAyat(ayatData: AyaatData)

}