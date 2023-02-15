package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class AyaatList : AppCompatActivity(),OnItemClickListener {
    lateinit var database: quranDb
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayaat_list)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }


        val ayaatObject = lists.getAyatList()

        val ayaatView = findViewById<RecyclerView>(R.id.ayaatView)

        val adapter = AyaatRecyclerAdapter(ayaatObject,this,this)
        ayaatView.adapter = adapter
        ayaatView.layoutManager = LinearLayoutManager(this)

        database = quranDb.getDatabase(this)
        database.qurandao().getAyat().observe(this) {
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
    override fun onClickFlash(){
        val intent = Intent(this,Flashes::class.java)
        this.startActivity(intent)
    }

    override fun onClickBookmark(position: Int,Ayaat : AyaatData) {
        if (Ayaat.is_bookmarked == 0) {
            Toast.makeText(this, "Bookmark saved", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                database.qurandao().updateAyat(1, Ayaat.id)
            }


        } else {
            Toast.makeText(this, "Bookmark removed", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {
                database.qurandao().updateAyat(0, Ayaat.id)
            }

        }
    }


}
