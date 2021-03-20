package com.example.happyexercise

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_status.view.*


class ExerciseStatusAdapter(val item: ArrayList<ExerciseModel>, val context: Context) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvItem = view.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_exercise_status,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = item[position]
        holder.tvItem.text = model.getId().toString()
        if (model.getIsSelectd()) {
            holder.tvItem.background =
                ContextCompat.getDrawable(context, R.drawable.item_exercise_radius_complete)
            holder.tvItem.setTextColor(Color.parseColor("#018786"))

        } else if (model.getIsComplete()) {
            holder.tvItem.background =
                ContextCompat.getDrawable(context, R.drawable.item_exercise_radius_complete)
            holder.tvItem.setTextColor(Color.parseColor("#018786"))

        } else  {
            holder.tvItem.background =
                ContextCompat.getDrawable(context, R.drawable.item_exercise_radius)
            holder.tvItem.setTextColor(Color.parseColor("#ffffff"))
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }
}