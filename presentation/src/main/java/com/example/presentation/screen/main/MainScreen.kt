package com.example.presentation.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.screen.StubScreen
import org.koin.androidx.compose.koinViewModel


@Composable
internal fun MainScreen(
    viewModel: MainViewModel = koinViewModel(),
    changeFavoriteCount: (Int) -> Unit,
    navigateToVacancyDetails: () -> Unit,
) {
    val mainScreenState by viewModel.getMainScreenState()
        .collectAsStateWithLifecycle()
    when (val state = mainScreenState) {
        MainScreenState.Initial -> StubScreen()
        is MainScreenState.Main -> MainScreenContent(
            vacancies = state.offersAndVacancies.vacancies,
            offers = state.offersAndVacancies.offers,
            searchValue = state.searchValue,
            changeFavoriteCount = changeFavoriteCount,
            navigateToVacancyDetails = navigateToVacancyDetails,
            onSearchValueChange = viewModel::changeSearchValue,
            onMoreVacancy = viewModel::toMoreVacanciesState,
            changeVacancyFavoriteStatus = viewModel::changeVacancyFavoriteStatus
        )

        is MainScreenState.More -> MainScreenMoreVacanciesContent(
            vacancies = state.vacancies,
            searchValue = state.searchValue,
            changeFavoriteCount = changeFavoriteCount,
            navigateToVacancyDetails = navigateToVacancyDetails,
            onSearchValueChange = viewModel::changeSearchValue,
            onMain = viewModel::toMainState,
            changeVacancyFavoriteStatus = viewModel::changeVacancyFavoriteStatus
        )
    }
}
