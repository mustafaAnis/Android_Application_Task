package com.example.androidapplicationtask
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuranDao {

    @Insert
    suspend fun insertAyat(ayaatData: AyaatData)

    @Query("update tbl_QuranComplete set is_Bookmarked = :bookmark where id = :id")
    suspend fun updateAyat(bookmark : Int,id: Int)


    @Query("select * from tbl_QuranComplete;")
    fun getAyat(): List<AyaatData>

}