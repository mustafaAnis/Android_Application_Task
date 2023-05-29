package com.example.androidapplicationtask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapplicationtask.model.AyaatData
import com.example.androidapplicationtask.repository.QuranRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AyaatViewModel(private val repo: QuranRepo): ViewModel() {

    fun getAyat(): LiveData<List<AyaatData>> {
        return repo.getAyat()
    }

    fun updateAyat(bookmark : Int,id: Int) {

        viewModelScope.launch(Dispatchers.IO) {
        repo.updateAyat(bookmark,id)
        }


    }
}