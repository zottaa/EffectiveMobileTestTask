package com.example.domain.usecase.impl

import com.example.domain.OffersAndVacanciesRepository
import com.example.domain.interactor.OffersAndVacanciesInteractor
import com.example.domain.models.OffersAndVacancies
import com.example.domain.usecase.GetOffersAndVacanciesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single

internal class GetOffersAndVacanciesUseCaseImpl(
    interactor: OffersAndVacanciesInteractor,
    private val repository: OffersAndVacanciesRepository
) : GetOffersAndVacanciesUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val offersAndVacancies =
        interactor.observeOffersAndVacancies()
            .flatMapLatest {
                repository.getOffersAndVacancies()
            }

    override fun invoke(): Flow<OffersAndVacancies> {
        return offersAndVacancies
    }
}