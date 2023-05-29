package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidapplicationtask.repository.QuranRepo

class SurahViewModelFactory(private val repo: QuranRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SurahViewModel(repo) as T
    }
}