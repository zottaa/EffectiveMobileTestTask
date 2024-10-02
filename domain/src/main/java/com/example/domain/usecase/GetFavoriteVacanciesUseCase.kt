package com.example.domain.usecase

import com.example.domain.models.Vacancy
import kotlinx.coroutines.flow.Flow

interface GetFavoriteVacanciesUseCase {
    operator fun invoke(): Flow<List<Vacancy>>
}