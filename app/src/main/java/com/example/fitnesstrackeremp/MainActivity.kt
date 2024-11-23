package com.example.fitnesstrackeremp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLog = findViewById<Button>(R.id.btnLog)
        val btnAddWorkout = findViewById<Button>(R.id.btnAddWorkout)

        btnLog.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        btnAddWorkout.setOnClickListener {
            val intent = Intent(this, AddWorkoutActivity::class.java)
            startActivity(intent)
        }
    }
}


