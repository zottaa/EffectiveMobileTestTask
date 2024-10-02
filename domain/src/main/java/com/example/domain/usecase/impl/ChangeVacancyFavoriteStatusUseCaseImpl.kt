package com.example.domain.usecase.impl

import com.example.domain.OffersAndVacanciesRepository
import com.example.domain.usecase.ChangeVacancyFavoriteStatusUseCase

internal class ChangeVacancyFavoriteStatusUseCaseImpl(
    private val repository: OffersAndVacanciesRepository
) : ChangeVacancyFavoriteStatusUseCase {
    override suspend fun invoke(vacancyId: String) {
        repository.changeFavoriteStatus(vacancyId)
    }
}