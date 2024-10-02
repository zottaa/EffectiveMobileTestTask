package com.example.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.NavigationBottomBar
import com.example.presentation.navigation.RootNavHost
import com.example.presentation.theme.Colors

@Composable
fun EffectiveMobileTestTaskApp() {
    val navController = rememberNavController()
    var favoriteCount by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Colors.black,
        bottomBar = {
            NavigationBottomBar(navController, favoriteCount)
        }
    ) { innerPadding ->
        RootNavHost(navController, innerPadding) { newFavoriteCount ->
            favoriteCount = newFavoriteCount
        }
    }
}
