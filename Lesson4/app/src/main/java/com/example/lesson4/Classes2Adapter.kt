package com.example.lesson4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.databinding.ItemListClasses21Binding
import com.example.lesson4.databinding.ItemListClasses22Binding

class Classes2Adapter(val a:Array<Lesson>,val onItemSkypeClickListener: OnItemSkypeClickListener) : RecyclerView.Adapter<Classes2Adapter.ViewHolder>() {
    private var binding:ItemListClasses21Binding?=null
    private var binding2: ItemListClasses22Binding?=null
    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (a[viewType].additional==false) {
            binding = ItemListClasses21Binding.inflate(LayoutInflater.from(parent.context))
            return BlackCardViewHolder(binding?.root)
        }
        else{
            binding2 = ItemListClasses22Binding.inflate(LayoutInflater.from(parent.context))
            return GreenCardViewHolder(binding2?.root)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(a[position],onItemSkypeClickListener)
    }

    override fun getItemCount(): Int {
        return a.size
    }
    fun onDestroy(){
        binding=null
        binding2=null
    }
    abstract class ViewHolder(view: View?): RecyclerView.ViewHolder(view!!){
        abstract fun bind(lesson:Lesson,onItemSkypeClickListener: OnItemSkypeClickListener)
    }
    class BlackCardViewHolder(view: View?): ViewHolder(view){
        override fun bind(lesson: Lesson,onItemSkypeClickListener: OnItemSkypeClickListener) {
            val tv = itemView.findViewById<TextView>(R.id.classes21)
            tv.setText(lesson.name+"\n"+lesson.time)
            val icSkype = itemView.findViewById<ImageView>(R.id.skype)
            icSkype.setOnClickListener{
                onItemSkypeClickListener.onCLick()
            }
        }
    }
    class GreenCardViewHolder(view: View?): ViewHolder(view)
    {
        override fun bind(lesson: Lesson,onItemSkypeClickListener: OnItemSkypeClickListener) {
            val tv = itemView.findViewById<TextView>(R.id.classes22)
            tv.setText(lesson.name+"\n"+lesson.time)
        }
    }
    interface OnItemSkypeClickListener{
        fun onCLick()
    }
}