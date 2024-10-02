package com.example.domain.usecase.impl

import com.example.domain.interactor.OffersAndVacanciesInteractor
import com.example.domain.usecase.LoadOffersAndVacanciesUseCase

internal class LoadOffersAndVacanciesUseCaseImpl(
    private val interactor: OffersAndVacanciesInteractor
): LoadOffersAndVacanciesUseCase  {
    override suspend fun invoke() {
        interactor.loadOffersAndVacancies()
    }
}
