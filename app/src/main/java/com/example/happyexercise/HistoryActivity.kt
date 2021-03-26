package com.example.happyexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_b_m_i.*
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar_history_activity)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)//hien nut back
            actionbar.title = "HISTORY WORKOUT"

        }
        toolbar_history_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        getAllComplete()
    }
    private  fun getAllComplete(){
        val dbHandle = SqliteOpenHelper(this, null)
       val allCompletedDate = dbHandle.getAllCompletedDate()
        if(allCompletedDate.size > 0){
            tvTitle.visibility = View.VISIBLE
            rvHistoryItem.visibility = View.VISIBLE
            tvNodata.visibility = View.GONE
            rvHistoryItem.layoutManager = LinearLayoutManager(this)
            val historyAdapter = HistoryAdapter(this, allCompletedDate)
            rvHistoryItem.adapter = historyAdapter
        }
        else {
            tvTitle.visibility = View.GONE
            rvHistoryItem.visibility = View.GONE
            tvNodata.visibility = View.VISIBLE
        }
    }
}