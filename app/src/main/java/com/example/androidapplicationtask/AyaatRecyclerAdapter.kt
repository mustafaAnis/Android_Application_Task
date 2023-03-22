package com.example.androidapplicationtask

import android.annotation.SuppressLint
import android.content.Context
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapplicationtask.databinding.AyatItemViewBinding

class AyaatRecyclerAdapter(
    val ayaat: List<AyaatData>,
    val listner: OnItemClickListenerForAyaat,
    val context: Context
) : RecyclerView.Adapter<AyaatRecyclerAdapter.AyaatViewHolder>() {
//    lateinit var database: quranDb
//    val ayatObject = lists.getAyatList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyaatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AyaatViewHolder(DataBindingUtil.inflate(inflater,R.layout.ayat_item_view, parent, false))
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
            binding.listener = listner
            binding.position = bindingAdapterPosition
            binding.executePendingBindings()



        }
    }
}




