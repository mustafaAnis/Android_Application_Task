package com.example.androidapplicationtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurahViewModel: ViewModel() {

    private val _surahObject = QuranRepo.getSurahList()


   val surahObject : MutableLiveData<List<Surah>> = _surahObject

//    val surahObject : MutableList<Surah> = _surahObject


}