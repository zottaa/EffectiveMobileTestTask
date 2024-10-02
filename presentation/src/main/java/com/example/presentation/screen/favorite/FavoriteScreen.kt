package com.example.presentation.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.screen.StubScreen
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
            navigateToVacancyDetails = navigateToVacancyDetails,
            changeVacancyFavoriteStatus = viewModel::changeFavoriteStatus
        )
    }
}
