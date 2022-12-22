package com.example.androidapplicationtask

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class QuranFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_quran, container, false)

        view.findViewById<Button>(R.id.btnQuran).setOnClickListener{
            val intent = Intent(context,SurahView::class.java)
            startActivity(intent)
        }

        return view

    }


}