package com.example.androidapplicationtask.db
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidapplicationtask.model.AyaatData

@Dao
interface QuranDao {

    @Insert
    suspend fun insertAyat(ayaatData: AyaatData)

    @Query("update tbl_QuranComplete set is_Bookmarked = :bookmark where id = :id")
    suspend fun updateAyat(bookmark : Int,id: Int)


    @Query("select * from tbl_QuranComplete;")
    fun getAyat(): LiveData<List<AyaatData>>

}