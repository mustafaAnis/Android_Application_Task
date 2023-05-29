package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidapplicationtask.repository.QuranRepo
import com.example.androidapplicationtask.model.Surah

class SurahViewModel(private val repo: QuranRepo): ViewModel() {

    private val _surahObject = repo.getSurahList()


   val surahObject : MutableLiveData<List<Surah>> = _surahObject

//    val surahObject : MutableList<Surah> = _surahObject


}