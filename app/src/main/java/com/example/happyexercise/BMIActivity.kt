package com.example.happyexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b_m_i.*

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)
        setSupportActionBar(toolbar_BMI_activity)
        val actionbar  =  supportActionBar
        if(actionbar != null){
            actionbar.setDisplayHomeAsUpEnabled(true)//hien nut back
            actionbar.title = "CALCULATE BMI"

        }
        toolbar_BMI_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}