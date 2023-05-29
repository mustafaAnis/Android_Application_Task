package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidapplicationtask.repository.QuranRepo

class AyaatViewModelFactory(private  val quranRepo: QuranRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AyaatViewModel(quranRepo) as T
    }
}