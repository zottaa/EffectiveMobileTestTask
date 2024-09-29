package com.example.effectivemobiletesttask

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.EffectiveMobileTestTaskApp
import com.example.presentation.models.OfferButtonUi
import com.example.presentation.models.OfferUi
import com.example.presentation.models.SalaryUi
import com.example.presentation.models.VacancyAddressUi
import com.example.presentation.models.VacancyExperienceUi
import com.example.presentation.models.VacancyUi
import com.example.presentation.screen.FavoriteScreenContent
import com.example.presentation.screen.MainScreenContent
import com.example.presentation.screen.MainScreenMoreVacanciesContent
import com.example.presentation.theme.EffectiveMobileTestTaskTheme
import com.example.presentation.uikit.IconType
import com.example.presentation.uikit.OfferCard
import com.example.presentation.uikit.SearchField
import com.example.presentation.uikit.SearchFieldPreview
import com.example.presentation.uikit.SearchFieldWithBackButton
import com.example.presentation.uikit.VacancyCard

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