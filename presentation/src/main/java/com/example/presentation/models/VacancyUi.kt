package com.example.presentation.models


internal data class VacancyUi(
    val id: String,
    val lookingNumber: Int = 0,
    val title: String,
    val address: VacancyAddressUi,
    val company: String,
    val experience: VacancyExperienceUi,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryUi?,
    val appliedNumber: Int?,
    val schedules: List<String>,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>
)

internal data class VacancyAddressUi(
    val town: String,
    val street: String,
    val house: String
)

internal data class VacancyExperienceUi(
    val previewText: String,
    val text: String
)

internal data class SalaryUi(
    val full: String?,
    val short: String?
)
