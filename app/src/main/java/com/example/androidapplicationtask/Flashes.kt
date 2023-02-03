package com.example.androidapplicationtask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class Flashes : AppCompatActivity() {

    private var post = mutableListOf <Post>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashes)
        val flashesView = findViewById<RecyclerView>(R.id.flashesView)


        val flashesAPI = RetrofitHelper.getInstance().create(FlashesAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            val result = flashesAPI.getFlashes()
            val resultBody = result.body()
            Log.d("post",resultBody?.data?.posts.toString())

            if(resultBody != null){
                post.addAll(resultBody.data.posts)

                withContext(Main){
                    Log.d("post in context",post.toString())
//                    flashesView.adapter = FlashesRecyclerAdapter(post,this@Flashes)
//                    flashesView.layoutManager = LinearLayoutManager(this@Flashes)


                }

            }




        }



    }
}