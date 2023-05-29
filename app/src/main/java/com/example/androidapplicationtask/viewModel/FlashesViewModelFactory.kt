package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidapplicationtask.repository.FlashesRepo

class FlashesViewModelFactory(private val repo: FlashesRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FlashesViewModel(repo) as T
    }
}