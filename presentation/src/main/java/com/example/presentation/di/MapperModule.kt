package com.example.presentation.di

import android.system.Os.bind
import com.example.presentation.mappers.OfferDomainToUiMapper
import com.example.presentation.mappers.OfferDomainToUiMapperImpl
import com.example.presentation.mappers.OffersAndVacanciesDomainToUiMapper
import com.example.presentation.mappers.OffersAndVacanciesDomainToUiMapperImpl
import com.example.presentation.mappers.SalaryDomainToUiMapper
import com.example.presentation.mappers.SalaryDomainToUiMapperImpl
import com.example.presentation.mappers.VacancyAddressDomainToUiMapper
import com.example.presentation.mappers.VacancyAddressDomainToUiMapperImpl
import com.example.presentation.mappers.VacancyDomainToUiMapper
import com.example.presentation.mappers.VacancyDomainToUiMapperImpl
import com.example.presentation.mappers.VacancyExperienceDomainToUiMapper
import com.example.presentation.mappers.VacancyExperienceDomainToUiMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val mapperModule = module {
    factoryOf(::OfferDomainToUiMapperImpl) {
        bind<OfferDomainToUiMapper>()
    }

    factoryOf(::OffersAndVacanciesDomainToUiMapperImpl) {
        bind<OffersAndVacanciesDomainToUiMapper>()
    }

    factoryOf(::SalaryDomainToUiMapperImpl) {
        bind<SalaryDomainToUiMapper>()
    }

    factoryOf(::VacancyAddressDomainToUiMapperImpl) {
        bind<VacancyAddressDomainToUiMapper>()
    }

    factoryOf(::VacancyDomainToUiMapperImpl) {
        bind<VacancyDomainToUiMapper>()
    }

    factoryOf(::VacancyExperienceDomainToUiMapperImpl) {
        bind<VacancyExperienceDomainToUiMapper>()
    }
}