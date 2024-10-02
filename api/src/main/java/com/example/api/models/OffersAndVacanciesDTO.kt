package com.example.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OffersAndVacanciesDTO(
    @SerialName("offers")
    val offers: List<OfferDTO>,
    @SerialName("vacancies")
    val vacancies: List<VacancyDTO>
)