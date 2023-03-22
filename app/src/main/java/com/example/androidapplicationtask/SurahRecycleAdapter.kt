package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidapplicationtask.databinding.SurahItemViewBinding

class SurahRecycleAdapter(
    val surah: List<Surah>,
    val context : Context,
    val listener:OnItemClickListenerForSurah
    ) : Adapter<SurahRecycleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(DataBindingUtil.inflate(inflater,R.layout.surah_item_view, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val model = surah[position]
        holder.bind(model)

    }


    override fun getItemCount(): Int {
        return surah.size
    }

    inner class MyViewHolder(val binding: SurahItemViewBinding) : ViewHolder(binding.root) {

        fun bind(model:Surah) {

            binding.model = model
            binding.listner = listener
            binding.position = bindingAdapterPosition
            binding.executePendingBindings()
        }
    }
}

