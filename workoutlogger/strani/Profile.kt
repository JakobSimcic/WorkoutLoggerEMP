package com.example.workoutlogger.strani

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF28282B)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WORKOUT PROFILE",
            fontSize = 35.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(top = 60.dp)
        )

        InputField(label = "Ime", value = name, onValueChange = { name = it })
        InputField(label = "Priimek", value = surname, onValueChange = { surname = it })
        InputField(label = "Teža (kg)", value = weight, onValueChange = { weight = it }, keyboardType = KeyboardType.Number)
        InputField(label = "Višina (cm)", value = height, onValueChange = { height = it }, keyboardType = KeyboardType.Number)
        InputField(label = "Rojstni datum (dd/mm/leto)", value = birthDate, onValueChange = { birthDate = it })
    }
}

@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit, keyboardType: KeyboardType = KeyboardType.Text) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.1f))
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
        )
    }
}
