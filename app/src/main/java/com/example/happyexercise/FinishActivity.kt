package com.example.happyexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        setSupportActionBar(toolbar_activity_finish)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar_activity_finish.setNavigationOnClickListener{
            onBackPressed()
        }
        btnFinish.setOnClickListener {
            finish()
        }
        addDateToDatabase()

    }
    private fun addDateToDatabase(){
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        val sdf = SimpleDateFormat("dd MMM YYYY HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        val dbHandler = SqliteOpenHelper(this, null)
        dbHandler.addDate(date)
    }
}