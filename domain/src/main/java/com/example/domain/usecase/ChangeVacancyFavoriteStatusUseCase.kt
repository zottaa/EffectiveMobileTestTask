package com.example.domain.usecase

interface ChangeVacancyFavoriteStatusUseCase {
    suspend operator fun invoke(vacancyId: String)
}

