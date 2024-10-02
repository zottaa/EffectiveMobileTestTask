package com.example.data.di

import com.example.api.OffersAndVacanciesApi
import com.example.api.ProvideOffersAndVacanciesApi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val apiModule = module {
    single {
        OffersAndVacanciesApi(baseUrl = "https://raw.githubusercontent.com/zottaa/EffectiveMobileTestTask/")
    }
}