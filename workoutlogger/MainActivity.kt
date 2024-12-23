package com.example.workoutlogger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workoutlogger.strani.LogaWorkout
import com.example.workoutlogger.ui.theme.WorkOutLoggerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkOutLoggerTheme {
                AppNavigation()

            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Logger") {
        composable("Logger") {
            Logger(navController = navController)
        }
        composable("LogaWorkout") {
            LogaWorkout()
        }
    }
}


