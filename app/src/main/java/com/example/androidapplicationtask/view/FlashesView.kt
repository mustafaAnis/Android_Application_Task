package com.example.androidapplicationtask.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapplicationtask.applicationClass.ApplicationClass
import com.example.androidapplicationtask.api.FlashesAPI
import com.example.androidapplicationtask.model.Post
import com.example.androidapplicationtask.R
import com.example.androidapplicationtask.adapter.FlashesRecyclerAdapter
import com.example.androidapplicationtask.databinding.ActivityFlashesBinding
import com.example.androidapplicationtask.repository.FlashesRepo
import com.example.androidapplicationtask.viewModel.FlashesViewModel
import com.example.androidapplicationtask.viewModel.FlashesViewModelFactory
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.lang.Exception

class FlashesView : AppCompatActivity() {
    lateinit var binding: ActivityFlashesBinding
    lateinit var mAdapter: FlashesRecyclerAdapter
    lateinit var viewModel : FlashesViewModel
    private var post = mutableListOf<Post>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlashesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = (application as ApplicationClass).flashesRepo

        viewModel =
            ViewModelProvider(this, FlashesViewModelFactory(repo))[FlashesViewModel::class.java]

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


        viewModel.flashes.observe(this) {
            if (it != null) {
                post.clear()
                post.addAll(it.data.posts)
                mAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Data is not available", Toast.LENGTH_SHORT).show()
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

