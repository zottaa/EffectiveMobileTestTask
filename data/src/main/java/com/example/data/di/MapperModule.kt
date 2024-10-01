package com.example.data.di

import com.example.data.mappers.OfferButtonDataToDomainMapper
import com.example.data.mappers.OfferButtonDataToDomainMapperImpl
import com.example.data.mappers.OfferDTOToDataMapper
import com.example.data.mappers.OfferDTOToDataMapperImpl
import com.example.data.mappers.OfferDataToDomainMapper
import com.example.data.mappers.OfferDataToDomainMapperImpl
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapper
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapperImpl
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapper
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapperImpl
import com.example.data.mappers.SalaryDTOToDataMapper
import com.example.data.mappers.SalaryDTOToDataMapperImpl
import com.example.data.mappers.SalaryDataToDomainMapper
import com.example.data.mappers.SalaryDataToDomainMapperImpl
import com.example.data.mappers.VacancyAddressDTOToDataMapper
import com.example.data.mappers.VacancyAddressDTOToDataMapperImpl
import com.example.data.mappers.VacancyAddressDataToDomainMapper
import com.example.data.mappers.VacancyAddressDataToDomainMapperImpl
import com.example.data.mappers.VacancyDTOToDataMapper
import com.example.data.mappers.VacancyDTOToDataMapperImpl
import com.example.data.mappers.VacancyDataToDomainMapper
import com.example.data.mappers.VacancyDataToDomainMapperImpl
import com.example.data.mappers.VacancyExperienceDTOToDataMapper
import com.example.data.mappers.VacancyExperienceDTOToDataMapperImpl
import com.example.data.mappers.VacancyExperienceDataToDomainMapper
import com.example.data.mappers.VacancyExperienceDataToDomainMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

internal val dataMapperModule = module {
    factoryOf(::OfferButtonDataToDomainMapperImpl) {
        bind<OfferButtonDataToDomainMapper>()
    }

    factoryOf(::OfferDataToDomainMapperImpl) {
        bind<OfferDataToDomainMapper>()
    }

    factoryOf(::OfferDTOToDataMapperImpl) {
        bind<OfferDTOToDataMapper>()
    }

    factoryOf(::OffersAndVacanciesDataToDomainMapperImpl) {
        bind<OffersAndVacanciesDataToDomainMapper>()
    }

    factoryOf(::OffersAndVacanciesDTOToDataMapperImpl) {
        bind<OffersAndVacanciesDTOToDataMapper>()
    }

    factoryOf(::SalaryDataToDomainMapperImpl) {
        bind<SalaryDataToDomainMapper>()
    }

    factoryOf(::SalaryDTOToDataMapperImpl) {
        bind<SalaryDTOToDataMapper>()
    }

    factoryOf(::VacancyAddressDataToDomainMapperImpl) {
        bind<VacancyAddressDataToDomainMapper>()
    }

    factoryOf(::VacancyAddressDTOToDataMapperImpl) {
        bind<VacancyAddressDTOToDataMapper>()
    }

    factoryOf(::VacancyDataToDomainMapperImpl) {
        bind<VacancyDataToDomainMapper>()
    }

    factoryOf(::VacancyDTOToDataMapperImpl) {
        bind<VacancyDTOToDataMapper>()
    }

    factoryOf(::VacancyExperienceDataToDomainMapperImpl) {
        bind<VacancyExperienceDataToDomainMapper>()
    }

    factoryOf(::VacancyExperienceDTOToDataMapperImpl) {
        bind<VacancyExperienceDTOToDataMapper>()
    }

}