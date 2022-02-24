package com.example.lesson5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    val postsList:ArrayList<Data2> = arrayListOf()
    fun setData(a:Array<Data2>){
        postsList.addAll(a)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(post:Data2){
            val tv = itemView.findViewById<TextView>(R.id.textView)
            tv.setText(post.data.permalink)
        }
    }
}