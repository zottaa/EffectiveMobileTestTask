package com.example.domain.di

import com.example.domain.usecase.GetFavoriteVacanciesUseCase
import com.example.domain.usecase.GetOffersAndVacanciesUseCase
import com.example.domain.usecase.LoadOffersAndVacanciesUseCase
import com.example.domain.usecase.impl.GetFavoriteVacanciesUseCaseImpl
import com.example.domain.usecase.impl.GetOffersAndVacanciesUseCaseImpl
import com.example.domain.usecase.impl.LoadOffersAndVacanciesUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCasesModule = module {
    factoryOf(::GetOffersAndVacanciesUseCaseImpl) {
        bind<GetOffersAndVacanciesUseCase>()
    }
    factoryOf(::GetFavoriteVacanciesUseCaseImpl) {
        bind<GetFavoriteVacanciesUseCase>()
    }
    factoryOf(::LoadOffersAndVacanciesUseCaseImpl) {
        bind<LoadOffersAndVacanciesUseCase>()
    }
}