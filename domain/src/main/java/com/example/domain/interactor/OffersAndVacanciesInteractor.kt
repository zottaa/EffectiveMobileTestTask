package com.example.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class OffersAndVacanciesInteractor {
    private val streamOffersAndVacancies: MutableSharedFlow<Unit> =
        MutableSharedFlow(replay = 1)

    fun loadOffersAndVacancies() {
        streamOffersAndVacancies.tryEmit(Unit)
    }

    fun observeOffersAndVacancies(): Flow<Unit> = streamOffersAndVacancies
}