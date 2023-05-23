package com.example.androidapplicationtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SurahViewModel: ViewModel() {

    private val _surahObject = lists.getSurahList()

    val surahObject : MutableList<Surah> = _surahObject

    fun add_surah_name(surah:Surah){
        _surahObject.add(surah)
    }

}