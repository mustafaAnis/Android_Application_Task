package com.example.androidapplicationtask

import androidx.lifecycle.MutableLiveData

object QuranRepo {

    fun getSurahList(): MutableLiveData<List<Surah>> {

        val surahListLiveData = MutableLiveData<List<Surah>>()
        val surahlist = mutableListOf<Surah>()

        surahlist.add(Surah(1,"Al-Fatihah",7))
        surahlist.add(Surah(2,"Al-Bakarah",286))
        surahlist.add(Surah(3,"Aali'imran",200))
        surahlist.add(Surah(4,"An-Nisa",176))
        surahlist.add(Surah(5,"Al-Ma'idah",120))
        surahlist.add(Surah(6,"Al-An'am",165))
        surahlist.add(Surah(7,"Al-Aeraaf",206))
        surahlist.add(Surah(8,"Al-Anfaal",75))


        surahListLiveData.value = surahlist
        return surahListLiveData

}

    fun getAyatList(): MutableList<AyaatData> {

        val ayatList = mutableListOf<AyaatData>()

        return ayatList

    }



}