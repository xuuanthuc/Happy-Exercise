package com.example.happyexercise

import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exercise.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProgress = 0

    private var exerciseList: ArrayList<ExerciseModel> ? = null
    private var currentExercisePosition = -1
    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        setSupportActionBar(toolbar_exercise_activity)
        var actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)//them trang chu hien thi khi ung dung udoc bat
        }
        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        tts = TextToSpeech(this,this)
        exerciseList = Constants.defaultExercise()
        setUpRestView()
    }

    private fun setRestProgressBar() {
        progressBar.progress = restProgress
        restTimer = object : CountDownTimer(10000, 1000) {
            //moi 1000 mls se hoat dong cho den khi het 10000mls
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress = 10 - restProgress
                tvTimer.text = "${10 - restProgress}"
            }

            override fun onFinish() {
                currentExercisePosition++
                setUpExerciseView()
            }
        }.start()
    }

    private fun setUpRestView() {
        llExerciseview.visibility = View.GONE
        llRestview.visibility = View.VISIBLE
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        speakOut("Time to rest")
        tvNextExercise.text = exerciseList!![currentExercisePosition + 1].getName()
        setRestProgressBar()


    }

    private fun setExerciseProgressBar() {
        progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(30000, 1000) {
            //moi 1000 mls se hoat dong cho den khi het 10000mls
            override fun onTick(millisUntilFinished: Long) {
                exerciseProgress++
                progressBarExercise.progress = 30 - exerciseProgress
                tvTimerExercise.text = "${30 - exerciseProgress}"
            }

            override fun onFinish() {
                if(currentExercisePosition < exerciseList?.size!! - 1){
                    setUpRestView()
                }
                else{ Toast.makeText(this@ExerciseActivity, "start", Toast.LENGTH_LONG).show() }
            }
        }.start()
    }

    private fun setUpExerciseView() {
        llExerciseview.visibility = View.VISIBLE
        llRestview.visibility = View.GONE
        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        speakOut(exerciseList!![currentExercisePosition].getName())
        setExerciseProgressBar()
        ivImage.setImageResource(exerciseList!![currentExercisePosition].getImg())
        tvExerciseName.text = exerciseList!![currentExercisePosition].getName()

    }
    override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProgress = 0
        }
        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProgress = 0
        }
        if(tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }

        super.onDestroy()
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("tts","Text To Speech Failed")
            }
            else {
                Log.e("tts","Text To Speech Failed")
            }

        }
    }
    private fun speakOut(text: String){
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH, null, "")
    }
}