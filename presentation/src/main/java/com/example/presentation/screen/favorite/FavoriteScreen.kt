package com.example.presentation.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.R
import com.example.presentation.models.VacancyUi
import com.example.presentation.screen.StubScreen
import com.example.presentation.theme.Colors
import com.example.presentation.theme.Typography
import com.example.presentation.uikit.VacancyCard
import com.example.presentation.utils.getVacanciesText
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun FavoriteScreen(
    viewModel: FavoriteViewModel = koinViewModel(),
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit
) {
    val favoriteScreenState by viewModel.getFavoriteScreenState().collectAsStateWithLifecycle()

    when (val state = favoriteScreenState) {
        FavoriteScreenState.Initial -> StubScreen()
        is FavoriteScreenState.Show -> FavoriteScreenContent(
            favoriteVacancies = state.vacancies,
            changeFavoriteCount = changeFavoriteCount,
            navigateToVacancyDetails = navigateToVacancyDetails
        )
    }
}

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
            Text(
                text = stringResource(R.string.favorite),
                style = Typography.title2,
                color = Colors.white,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        item {
            Text(
                text = getVacanciesText(context, favoriteVacancies.size),
                style = Typography.text1,
                color = Colors.grey3,
            )
        }
        items(favoriteVacancies) { vacancy ->
            VacancyCard(vacancy = vacancy) {
                navigateToVacancyDetails()
            }
        }
    }
}