package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapplicationtask.model.FlashesList
import com.example.androidapplicationtask.repository.FlashesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlashesViewModel(private val repo: FlashesRepo) : ViewModel() {



    init {
        viewModelScope.launch(Dispatchers.IO) {

            repo.getFlashes()

        }

    }

    val flashes: LiveData<FlashesList>
        get() = repo.flashes


}