package com.example.fitnesstrackeremp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddWorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addworkout)

        val etWorkoutName = findViewById<EditText>(R.id.etWorkoutName)
        val etWorkoutDate = findViewById<EditText>(R.id.etWorkoutDate)
        val etWorkoutType = findViewById<EditText>(R.id.etWorkoutType)

        val etWorkoutDetails = findViewById<EditText>(R.id.etWorkoutDetails)

        val btnSaveWorkout = findViewById<Button>(R.id.btnSaveWorkout)

        btnSaveWorkout.setOnClickListener {
            val workoutName = etWorkoutName.text.toString()
            val workoutDate = etWorkoutDate.text.toString()
            val workoutType = etWorkoutType.text.toString()
            val workoutDetails = etWorkoutDetails.text.toString()

            if (workoutName.isEmpty() || workoutDate.isEmpty() || workoutType.isEmpty() || workoutDetails.isEmpty()) {
                Toast.makeText(this, "Prosimo, izpolnite vsa polja.", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(
                    this,
                    "Shranjeno: \nIme: $workoutName\nDatum: $workoutDate\nVrsta: $workoutType\nPodrobnosti: $workoutDetails",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

