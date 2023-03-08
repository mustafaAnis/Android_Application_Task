package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtask.databinding.ActivityAyaatListBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AyaatList : AppCompatActivity(),OnItemClickListenerForAyaat {
    lateinit var binding: ActivityAyaatListBinding

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyaatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }


        val ayaatObject = lists.getAyatList()

        val ayaatView = binding.ayaatView

        val adapter = AyaatRecyclerAdapter(ayaatObject,this,this)
        ayaatView.adapter = adapter
        ayaatView.layoutManager = LinearLayoutManager(this)

        ApplicationClass.database.qurandao().getAyat().observe(this) {
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
        val intent = Intent(this,Flashes::class.java)
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
