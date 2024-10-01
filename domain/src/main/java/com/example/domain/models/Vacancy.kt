package com.example.domain.models

data class Vacancy(
    val id: String,
    val lookingNumber: Int = 0,
    val title: String,
    val address: VacancyAddress,
    val company: String,
    val experience: VacancyExperience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: Salary,
    val appliedNumber: Int?,
    val schedules: List<String>,
    val description: String?,
    val responsibilities: String?,
    val questions: List<String>
)

data class VacancyAddress(
    val town: String,
    val street: String,
    val house: String
)

data class VacancyExperience(
    val previewText: String,
    val text: String
)

data class Salary(
    val full: String,
    val short: String?
)