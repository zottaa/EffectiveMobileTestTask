package com.example.presentation.models

data class OffersAndVacanciesUi(
    val offers: List<OfferUi> = emptyList(),
    val vacancies: List<VacancyUi> = emptyList()
)