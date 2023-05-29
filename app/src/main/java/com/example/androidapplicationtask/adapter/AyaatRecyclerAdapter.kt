package com.example.androidapplicationtask.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.androidapplicationtask.model.AyaatData
import com.example.androidapplicationtask.listeners.OnItemClickListenerForAyaat
import com.example.androidapplicationtask.R
import com.example.androidapplicationtask.databinding.AyatItemViewBinding

class AyaatRecyclerAdapter(
    val ayaat: List<AyaatData>,
    val onItemClickListener: OnItemClickListenerForAyaat,
    val context: Context
) : Adapter<AyaatRecyclerAdapter.AyaatViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyaatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AyaatViewHolder(DataBindingUtil.inflate(inflater,
            R.layout.ayat_item_view, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AyaatViewHolder, position: Int) {

        val model = ayaat[position]
        holder.bind(model)
        
    }

    override fun getItemCount(): Int {
        return ayaat.size
    }

    inner class AyaatViewHolder(val binding : AyatItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model : AyaatData){
            binding.model = model
            binding.listener = onItemClickListener
            binding.position = bindingAdapterPosition
            binding.executePendingBindings()



        }
    }
}




