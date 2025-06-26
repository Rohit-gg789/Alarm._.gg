package com.example.alarmbutton

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer


class AlarmDismissActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null


    private lateinit var sequenceText: TextView
    private lateinit var btnCircle: Button
    private lateinit var btnCross: Button
    private lateinit var btnTriangle: Button
    private lateinit var btnSquare: Button

    private val symbols = listOf("O", "X", "△", "□")
    private var generatedSequence = mutableListOf<String>()
    private var userProgress = 0
    private var currentLevel = 1
    private val totalLevels = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_dismiss)

        sequenceText = findViewById(R.id.sequenceText)
        btnCircle = findViewById(R.id.btnCircle)
        btnCross = findViewById(R.id.btnCross)
        btnTriangle = findViewById(R.id.btnTriangle)
        btnSquare = findViewById(R.id.btnSquare)

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()


        startNewLevel()

        btnCircle.setOnClickListener { checkInput("O") }
        btnCross.setOnClickListener { checkInput("X") }
        btnTriangle.setOnClickListener { checkInput("△") }
        btnSquare.setOnClickListener { checkInput("□") }
    }

    private fun startNewLevel() {
        generatedSequence.clear()
        repeat(5) {
            generatedSequence.add(symbols.random())
        }
        userProgress = 0
        sequenceText.text = "Level $currentLevel: ${generatedSequence.joinToString(" ")}"
    }

    private fun checkInput(input: String) {
        if (input == generatedSequence[userProgress]) {
            userProgress++
            if (userProgress == generatedSequence.size) {
                if (currentLevel == totalLevels) {
                    Toast.makeText(this, "✅ Alarm Dismissed! You're a champ 💪", Toast.LENGTH_LONG).show()
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null

                    finish()
                } else {
                    Toast.makeText(this, "✔️ Level $currentLevel Complete!", Toast.LENGTH_SHORT).show()
                    currentLevel++
                    startNewLevel()
                }
            }
        } else {
            Toast.makeText(this, "❌ Wrong! Restarting from Level 1", Toast.LENGTH_SHORT).show()
            currentLevel = 1
            startNewLevel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }

}
