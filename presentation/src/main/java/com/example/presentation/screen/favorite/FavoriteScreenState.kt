package com.example.presentation.screen.favorite

import com.example.presentation.models.VacancyUi


internal sealed class FavoriteScreenState {
    data object Initial : FavoriteScreenState()

    data class Show(val vacancies: List<VacancyUi>) :
        FavoriteScreenState()
}