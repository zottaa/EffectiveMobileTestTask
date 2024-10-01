package com.example.presentation.screen.main

import com.example.presentation.models.OffersAndVacanciesUi
import com.example.presentation.models.VacancyUi

internal sealed class MainScreenState {
    data object Initial : MainScreenState()

    data class Main(val offersAndVacancies: OffersAndVacanciesUi, val searchValue: String) :
        MainScreenState()

    data class More(val vacancies: List<VacancyUi>, val searchValue: String) : MainScreenState()
}