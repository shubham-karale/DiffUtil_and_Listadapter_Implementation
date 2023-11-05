package com.example.diffutil_and_listadapter_implementation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//STEPS:
//1. Create a class that extends ListAdapter class
//2. Create a class that extends RecyclerView.ViewHolder class
//3. Create a class that extends DiffUtil.ItemCallback class
//4. Create a layout file for each row of the RecyclerView

class ProgrammingAdapter():ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()){
    class ProgrammingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.name)

        fun bind(item:ProgrammingItem){
            name.text = item.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem == newItem
        }

    }

}