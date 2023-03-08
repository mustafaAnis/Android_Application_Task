package com.example.androidapplicationtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtask.databinding.ActivityFlashesBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.lang.Exception

class Flashes : AppCompatActivity() {
    lateinit var binding: ActivityFlashesBinding
    lateinit var mAdapter: FlashesRecyclerAdapter
    private var post = mutableListOf<Post>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlashesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.myToolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        //val flashesView = findViewById<RecyclerView>(R.id.flashesView)

        mAdapter = FlashesRecyclerAdapter(post, this)
        binding.flashesView.adapter = mAdapter
        binding.flashesView.layoutManager = LinearLayoutManager(this)


        CoroutineScope(Main).launch {
            val flashes = getFlashes()
            if (flashes.isNotEmpty()) {
                post.clear()
                post.addAll(flashes)
                mAdapter.notifyDataSetChanged()

            } else {
                Toast.makeText(this@Flashes, "Data is not available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun getFlashes(): MutableList<Post> = withContext(IO) {
        val resultBody = mutableListOf<Post>()
        try {


            val result = ApplicationClass.retrofitData.create(FlashesAPI::class.java).getFlashes()
            val resultbody = result.body()
            if (resultbody != null) {
                resultBody.addAll(resultbody.data.posts)
            }
        } catch (e: Exception) {
            Log.d("RetroFit",e.toString())
        }
        return@withContext resultBody

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()

            }
        }
        return super.onOptionsItemSelected(item)
    }
}

