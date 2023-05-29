package com.example.androidapplicationtask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidapplicationtask.api.FlashesAPI
import com.example.androidapplicationtask.applicationClass.ApplicationClass
import com.example.androidapplicationtask.model.FlashesList
import com.example.androidapplicationtask.model.Post
import retrofit2.http.POST
import java.lang.Exception

class FlashesRepo(private val flashesAPI: FlashesAPI) {

private val flashesLiveData = MutableLiveData<FlashesList>()

    val flashes : LiveData<FlashesList>
        get() = flashesLiveData

    suspend fun getFlashes(){
        try {
            val result = flashesAPI.getFlashes()
            if (result.body() != null){
                flashesLiveData.postValue(result.body())
            }
        } catch (e: Exception) {
            Log.d("RetroFit",e.toString())
        }

    }

}

