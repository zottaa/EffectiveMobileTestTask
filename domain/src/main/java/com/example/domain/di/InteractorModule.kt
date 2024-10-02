package com.example.domain.di

import com.example.domain.interactor.OffersAndVacanciesInteractor
import org.koin.dsl.module

internal val interactorModule = module {
    single {
        OffersAndVacanciesInteractor()
    }
}