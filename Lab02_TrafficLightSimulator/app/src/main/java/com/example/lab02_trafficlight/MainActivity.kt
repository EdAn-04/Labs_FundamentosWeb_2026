package com.example.lab02_trafficlight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

// Enum que define los estados del semáforo
enum class Light {
    Red,
    Yellow,
    Green
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrafficLight()
        }
    }
}

@Composable
fun TrafficLight() {

    // Estado actual del semáforo
    var currentLight by remember { mutableStateOf(Light.Red) }

    // Lógica automática del semáforo
    LaunchedEffect(Unit) {
        while (true) {
            currentLight = Light.Red
            delay(2000)

            currentLight = Light.Green
            delay(2000)

            currentLight = Light.Yellow
            delay(1000)
        }
    }

    // UI centrada en pantalla
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LightCircle(
            color = Color.Red,
            isActive = currentLight == Light.Red
        )

        Spacer(modifier = Modifier.height(16.dp))

        LightCircle(
            color = Color.Yellow,
            isActive = currentLight == Light.Yellow
        )

        Spacer(modifier = Modifier.height(16.dp))

        LightCircle(
            color = Color.Green,
            isActive = currentLight == Light.Green
        )
    }
}

@Composable
fun LightCircle(color: Color, isActive: Boolean) {

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(
                if (isActive) color else Color.Gray
            )
    )
}
