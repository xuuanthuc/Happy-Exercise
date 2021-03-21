package com.example.happyexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llStart.setOnClickListener {
            var intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }
        llBMI.setOnClickListener {
            var intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }
    }
}