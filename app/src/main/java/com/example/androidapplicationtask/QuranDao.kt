package com.example.androidapplicationtask
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuranDao {

    @Insert
    suspend fun insertAyat(ayaatData: tbl_QuranComplete)

    @Update
    suspend fun updateAyat(ayaatData: tbl_QuranComplete)

    @Query("select * from tbl_QuranComplete")
    fun getAyat(): List<tbl_QuranComplete>

}