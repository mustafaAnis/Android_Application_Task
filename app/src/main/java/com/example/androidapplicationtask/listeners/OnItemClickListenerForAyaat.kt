package com.example.androidapplicationtask.listeners

import com.example.androidapplicationtask.model.AyaatData


interface OnItemClickListenerForAyaat {

    fun onItemClickFlash()

    fun onItemClickBookmark(position : Int, AyaatObject : AyaatData)

}