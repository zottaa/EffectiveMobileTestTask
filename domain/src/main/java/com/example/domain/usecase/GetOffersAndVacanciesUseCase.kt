package com.example.domain.usecase

import com.example.domain.models.OffersAndVacancies
import kotlinx.coroutines.flow.Flow

interface GetOffersAndVacanciesUseCase {
    operator fun invoke(): Flow<OffersAndVacancies>
}