package com.example.presentation.screen.favorite

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.models.VacancyUi
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.VacancyCard
import com.example.presentation.utils.getVacanciesText

@Composable
fun FavoriteScreenContent(
    favoriteVacancies: List<VacancyUi>,
    modifier: Modifier = Modifier,
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit
) {
    val context = LocalContext.current
    changeFavoriteCount(favoriteVacancies.size)

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        item {
            HeaderSection()
        }
        item {
            VacanciesCountText(context, favoriteVacancies.size)
        }
        items(favoriteVacancies) { vacancy ->
            VacancyCard(vacancy = vacancy) {
                navigateToVacancyDetails()
            }
        }
    }
}

@Composable
private fun HeaderSection() {
    Text(
        text = stringResource(R.string.favorite),
        style = Typography.title2,
        color = Colors.white,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun VacanciesCountText(context: Context, count: Int) {
    Text(
        text = getVacanciesText(context, count),
        style = Typography.text1,
        color = Colors.grey3,
    )
}