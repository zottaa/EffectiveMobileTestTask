package com.example.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VacancyDTO(
    @SerialName("id")
    val id: String,
    @SerialName("lookingNumber")
    val lookingNumber: Int?,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: VacancyAddressDTO,
    @SerialName("company")
    val company: String,
    @SerialName("experience")
    val experience: VacancyExperienceDTO,
    @SerialName("publishedDate")
    val publishedDate: String,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
    @SerialName("salary")
    val salary: SalaryDTO,
    @SerialName("appliedNumber")
    val appliedNumber: Int?,
    @SerialName("schedules")
    val schedules: List<String>,
    @SerialName("description")
    val description: String?,
    @SerialName("responsibilities")
    val responsibilities: String?,
    @SerialName("questions")
    val questions: List<String>
)

@Serializable
data class VacancyAddressDTO(
    @SerialName("town")
    val town: String,
    @SerialName("street")
    val street: String,
    @SerialName("house")
    val house: String
)

@Serializable
data class VacancyExperienceDTO(
    @SerialName("previewText")
    val previewText: String,
    @SerialName("text")
    val text: String
)

@Serializable
data class SalaryDTO(
    @SerialName("full")
    val full: String,
    @SerialName("short")
    val short: String?
)

