package com.example.androidapplicationtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class Flashes : AppCompatActivity() {

    private var post = mutableListOf<Post>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashes)

        setSupportActionBar(findViewById(R.id.my_toolbar))
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.back_button)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        val flashesView = findViewById<RecyclerView>(R.id.flashesView)

        val adapter = FlashesRecyclerAdapter(post, this)
        flashesView.adapter = adapter
        flashesView.layoutManager = LinearLayoutManager(this)


        val flashesAPI = ApplicationClass.retrofitData.create(FlashesAPI::class.java)
        CoroutineScope(IO).launch {
            try {
                val result = flashesAPI.getFlashes()
                val resultBody = result.body()


                if (resultBody != null) {
                    post.clear()
                    post.addAll(resultBody.data.posts)
                    withContext(Main) {
                        adapter.notifyDataSetChanged()
                    }
                }else{
                    withContext(Main) {
                        Toast.makeText(this@Flashes, "Data is null", Toast.LENGTH_SHORT).show()
                    }

                }


            } catch (e: java.lang.Exception) {
                withContext(Main) {
                    Toast.makeText(this@Flashes, e.toString(), Toast.LENGTH_LONG).show()
                }
            }


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
}