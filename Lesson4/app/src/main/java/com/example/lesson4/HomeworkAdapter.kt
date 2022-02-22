package com.example.lesson4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.databinding.ItemListHomeworkBinding

class HomeworkAdapter(val a:Array<Homework>) : RecyclerView.Adapter<HomeworkAdapter.ViewHolder>() {
    private var binding:ItemListHomeworkBinding?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListHomeworkBinding.inflate(LayoutInflater.from(parent.context))
        return HomeworkAdapter.ViewHolder(binding?.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(a[position])
    }

    override fun getItemCount(): Int {
        return a.size
    }
    fun onDestroy(){
        binding = null
    }
    class ViewHolder(view: View?): RecyclerView.ViewHolder(view!!){
         fun bind(homework:Homework){
             val tv = itemView.findViewById<TextView>(R.id.homework)
             tv.setText(homework.subject+"\n"+homework.homework)
         }
    }
}