package com.example.androidapplicationtask

object lists {

    fun getSurahList(): MutableList<Surah> {

    val surahlist = mutableListOf<Surah>()
    surahlist.add(Surah(1,"Al-Fatihah",7))
    surahlist.add(Surah(2,"Al-Bakarah",286))
    surahlist.add(Surah(3,"Aali'imran",200))
    surahlist.add(Surah(4,"An-Nisa",176))
    surahlist.add(Surah(5,"Al-Ma'idah",120))
    surahlist.add(Surah(6,"Al-An'am",165))
        return surahlist

}



}