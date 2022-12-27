package com.example.androidapplicationtask
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuranDao {


    suspend fun insertAyat(ayaatData: AyaatData)

    suspend fun updateAyat()

    @Query("select * from tbl_QuranComplete")
    fun getAyat():LiveData< List<AyaatData> >

}