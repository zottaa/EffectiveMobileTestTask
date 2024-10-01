package com.example.effectivemobiletesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.presentation.EffectiveMobileTestTaskApp
import com.example.presentation.theme.EffectiveMobileTestTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileTestTaskTheme {
                EffectiveMobileTestTaskApp()
            }
        }
    }
}