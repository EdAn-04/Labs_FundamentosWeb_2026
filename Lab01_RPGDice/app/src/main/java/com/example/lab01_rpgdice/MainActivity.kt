package com.example.lab01_rpgdice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
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

    val total = vitality + dexterity + wisdom

    Column {
        Text("RPG Dice Roller")

        StatRow("Vitality", vitality) { vitality = (1..25).random() }
        StatRow("Dexterity", dexterity) { dexterity = (1..25).random() }
        StatRow("Wisdom", wisdom) { wisdom = (1..25).random() }

        Text("Total: $total")

        if (total < 30) {
            Text("Re-roll recommended!", color = Color.Red)
        } else if (total >= 50) {
            Text("Godlike!", color = Color(0xFFFFD700))
        }
    }
}

@Composable
fun StatRow(name: String, value: Int, onRoll: () -> Unit) {
    Column {
        Text("$name: $value")
        Button(onClick = onRoll) { Text("Roll $name") }
    }
}

@Preview(showBackground = true)
@Composable
fun RPGDiceScreenPreview() {
    Lab01_RPGDiceTheme {
        RPGDiceScreen()
    }
}
