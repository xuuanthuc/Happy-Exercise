package com.example.happyexercise

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history.view.*

class HistoryAdapter(val context: Context, val items: ArrayList<String>):
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val llHistory = view.llHistory!!
        val tvItem = view.tvDateComplete!!
        val tvPosition = view.tvPosition!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_history,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date :String = items.get(position)
        holder.tvPosition.text = (position + 1).toString()
        holder.tvItem.text = date
        if(position % 2 == 0){
            holder.llHistory.setBackgroundColor(Color.parseColor("#EBEBEB"))
        }
        else {
            holder.llHistory.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
}