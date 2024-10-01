package com.example.data.di

import com.example.data.OffersAndVacanciesRepositoryImpl
import com.example.domain.OffersAndVacanciesRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryModule = module {
    singleOf(::OffersAndVacanciesRepositoryImpl) {
        bind<OffersAndVacanciesRepository>()
    }
}