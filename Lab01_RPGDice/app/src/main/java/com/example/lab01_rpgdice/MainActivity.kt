package com.example.lab01_rpgdice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab01_rpgdice.ui.theme.Lab01_RPGDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01_RPGDiceTheme {
                RPGDiceScreen()
            }
        }
    }
}

@Composable
fun RPGDiceScreen() {
    var vitality by remember { mutableIntStateOf(10) }
    var dexterity by remember { mutableIntStateOf(10) }
    var wisdom by remember { mutableIntStateOf(10) }
    Column {
        Text("RPG Dice Roller")
    }
}

@Preview(showBackground = true)
@Composable
fun StatRow(name: String, value: Int, onRoll: () -> Unit) {
    Column {
        Text("$name: $value")
        Button(onClick = onRoll) { Text("Roll $name") }
    }
}