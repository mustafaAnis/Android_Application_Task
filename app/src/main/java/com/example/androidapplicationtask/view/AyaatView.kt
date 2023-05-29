package com.example.androidapplicationtask.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapplicationtask.applicationClass.ApplicationClass
import com.example.androidapplicationtask.model.AyaatData
import com.example.androidapplicationtask.listeners.OnItemClickListenerForAyaat
import com.example.androidapplicationtask.repository.QuranRepo
import com.example.androidapplicationtask.R
import com.example.androidapplicationtask.adapter.AyaatRecyclerAdapter
import com.example.androidapplicationtask.databinding.ActivityAyaatListBinding
import com.example.androidapplicationtask.viewModel.AyaatViewModel
import com.example.androidapplicationtask.viewModel.AyaatViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AyaatView : AppCompatActivity(), OnItemClickListenerForAyaat {
    lateinit var binding: ActivityAyaatListBinding
    lateinit var viewModel: AyaatViewModel

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyaatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = (application as ApplicationClass).quranRepo

        viewModel = ViewModelProvider(this, AyaatViewModelFactory(repo))[AyaatViewModel::class.java]

        setSupportActionBar(binding.myToolbar)
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }


        val ayaatObject = mutableListOf<AyaatData>()

        val ayaatView = binding.ayaatView

        val adapter = AyaatRecyclerAdapter(ayaatObject,this,this)
        ayaatView.adapter = adapter
        ayaatView.layoutManager = LinearLayoutManager(this)

        viewModel.getAyat().observe(this) {
            ayaatObject.clear()
            ayaatObject.addAll(it)
//            val item = it.filter { it.is_bookmarked == 1 }
//            adapter.notifyItemChanged(0,item.single())
            adapter.notifyDataSetChanged()

        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()

            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onItemClickFlash(){
        val intent = Intent(this, FlashesView::class.java)
        this.startActivity(intent)
    }

    override fun onItemClickBookmark(position: Int, Ayaat : AyaatData) {
        if (Ayaat.is_bookmarked == 0) {
            Toast.makeText(this, "Bookmark saved", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                ApplicationClass.database.qurandao().updateAyat(1, Ayaat.id)
            }


        } else {
            Toast.makeText(this, "Bookmark removed", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                ApplicationClass.database.qurandao().updateAyat(0, Ayaat.id)
            }

        }
    }


}
