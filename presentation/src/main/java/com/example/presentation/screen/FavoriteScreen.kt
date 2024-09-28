package com.example.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.VacancyCard

@Composable
fun FavoriteScreenContent(
    favoriteVacancies: List<VacancyUi>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item {
            Text(
                text = "Избранное",
                style = Typography.title2,
                color = Colors.white,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        item {
            Text(
                text = "${favoriteVacancies.size} вакансий",
                style = Typography.text1,
                color = Colors.grey3,
            )
        }
        items(favoriteVacancies) { vacancy ->
            VacancyCard(vacancy = vacancy)
        }
    }
}