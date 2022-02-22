package com.example.lesson4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.databinding.ItemListClasses1Binding

class Classes1Adapter(val a:Array<Lesson>) : RecyclerView.Adapter<Classes1Adapter.ViewHolder>() {
    private var binding:ItemListClasses1Binding?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListClasses1Binding.inflate(LayoutInflater.from(parent.context))
        return Classes1Adapter.ViewHolder(binding?.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(a[position])
    }

    override fun getItemCount(): Int {
        return a.size
    }
    fun onDestroy(){
        binding=null
    }
    class ViewHolder(view: View?):RecyclerView.ViewHolder(view!!){
        fun bind(lesson: Lesson){
            val tv = itemView.findViewById<TextView>(R.id.classes1)
            tv.setText(lesson.name + "\n" + lesson.time)
        }
    }
}