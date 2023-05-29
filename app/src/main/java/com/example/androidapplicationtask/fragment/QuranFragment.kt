package com.example.androidapplicationtask.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.androidapplicationtask.R
import com.example.androidapplicationtask.databinding.FragmentQuranBinding
import com.example.androidapplicationtask.view.SurahView

class QuranFragment : Fragment() {

    lateinit var binding: FragmentQuranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quran, container,false)

        binding.btnQuran.setOnClickListener{
            val intent = Intent(context, SurahView::class.java)
            startActivity(intent)
        }

        return binding.root

    }



}