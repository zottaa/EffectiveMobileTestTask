package com.example.data.models

internal data class VacancyData(
    val id: String,
    val lookingNumber: Int = 0,
    val title: String,
    val address: VacancyAddressData,
    val company: String,
    val experience: VacancyExperienceData,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryData,
    val appliedNumber: Int?,
    val schedules: List<String>,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>
)

internal data class VacancyAddressData(
    val town: String,
    val street: String,
    val house: String
)

internal data class VacancyExperienceData(
    val previewText: String,
    val text: String
)

internal data class SalaryData(
    val full: String,
    val short: String?
)