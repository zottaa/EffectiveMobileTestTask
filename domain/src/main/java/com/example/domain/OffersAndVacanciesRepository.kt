package com.example.domain

import com.example.domain.models.OffersAndVacancies
import com.example.domain.models.Vacancy
import kotlinx.coroutines.flow.Flow

interface OffersAndVacanciesRepository {
    fun getOffersAndVacancies(): Flow<OffersAndVacancies>
}