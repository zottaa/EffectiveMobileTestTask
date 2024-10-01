package com.example.domain.usecase.impl

import com.example.domain.OffersAndVacanciesRepository
import com.example.domain.interactor.OffersAndVacanciesInteractor
import com.example.domain.models.Vacancy
import com.example.domain.usecase.GetFavoriteVacanciesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map


internal class GetFavoriteVacanciesUseCaseImpl(
    interactor: OffersAndVacanciesInteractor,
    private val repository: OffersAndVacanciesRepository
) : GetFavoriteVacanciesUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val offersAndVacancies = interactor.observeOffersAndVacancies().flatMapLatest {
        repository.getOffersAndVacancies().map { offersAndVacancies ->
            offersAndVacancies.vacancies.filter { vacancy ->
                vacancy.isFavorite
            }
        }
    }

    override fun invoke(): Flow<List<Vacancy>> = offersAndVacancies
}