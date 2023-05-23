package com.example.androidapplicationtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapplicationtask.databinding.ActivityQuranBinding

class SurahView : AppCompatActivity(), OnItemClickListenerForSurah {
    lateinit var binding: ActivityQuranBinding
    private val viewModel: SurahViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }


        viewModel.add_surah_name(Surah(1,"Al-Fatihah",7))
        viewModel.add_surah_name(Surah(2,"Al-Bakarah",286))
        viewModel.add_surah_name(Surah(3,"Aali'imran",200))
        viewModel.add_surah_name(Surah(4,"An-Nisa",176))
        viewModel.add_surah_name(Surah(5,"Al-Ma'idah",120))
        viewModel.add_surah_name(Surah(6,"Al-An'am",165))
        viewModel.add_surah_name(Surah(7,"Al-Aeraaf",206))
        viewModel.add_surah_name(Surah(8,"Al-Anfaal",75))



        val surahList = binding.surahList
        surahList.adapter = SurahRecycleAdapter(viewModel.surahObject,this,this)
        surahList.layoutManager = LinearLayoutManager(this)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickSurah(position: Int) {
        if(position == 0){
            val intent = Intent(this,AyaatList::class.java)
            this.startActivity(intent)
        }
        else{
            Toast.makeText(this, "No Data Available ", Toast.LENGTH_SHORT).show()
        }
    }
}
