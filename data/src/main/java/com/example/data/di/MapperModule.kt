package com.example.data.di

import com.example.data.mappers.OfferButtonDBOToDataMapper
import com.example.data.mappers.OfferButtonDBOToDataMapperImpl
import com.example.data.mappers.OfferButtonDataToDBOMapper
import com.example.data.mappers.OfferButtonDataToDBOMapperImpl
import com.example.data.mappers.OfferButtonDataToDomainMapper
import com.example.data.mappers.OfferButtonDataToDomainMapperImpl
import com.example.data.mappers.OfferDBOToDataMapper
import com.example.data.mappers.OfferDBOToDataMapperImpl
import com.example.data.mappers.OfferDTOToDataMapper
import com.example.data.mappers.OfferDTOToDataMapperImpl
import com.example.data.mappers.OfferDataToDBOMapper
import com.example.data.mappers.OfferDataToDBOMapperImpl
import com.example.data.mappers.OfferDataToDomainMapper
import com.example.data.mappers.OfferDataToDomainMapperImpl
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapper
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapperImpl
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapper
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapperImpl
import com.example.data.mappers.SalaryDBOToDataMapper
import com.example.data.mappers.SalaryDBOToDataMapperImpl
import com.example.data.mappers.SalaryDTOToDataMapper
import com.example.data.mappers.SalaryDTOToDataMapperImpl
import com.example.data.mappers.SalaryDataToDBOMapper
import com.example.data.mappers.SalaryDataToDBOMapperImpl
import com.example.data.mappers.SalaryDataToDomainMapper
import com.example.data.mappers.SalaryDataToDomainMapperImpl
import com.example.data.mappers.VacancyAddressDBOToDataMapper
import com.example.data.mappers.VacancyAddressDBOToDataMapperImpl
import com.example.data.mappers.VacancyAddressDTOToDataMapper
import com.example.data.mappers.VacancyAddressDTOToDataMapperImpl
import com.example.data.mappers.VacancyAddressDataToDBOMapper
import com.example.data.mappers.VacancyAddressDataToDBOMapperImpl
import com.example.data.mappers.VacancyAddressDataToDomainMapper
import com.example.data.mappers.VacancyAddressDataToDomainMapperImpl
import com.example.data.mappers.VacancyDBOToDataMapper
import com.example.data.mappers.VacancyDBOToDataMapperImpl
import com.example.data.mappers.VacancyDTOToDataMapper
import com.example.data.mappers.VacancyDTOToDataMapperImpl
import com.example.data.mappers.VacancyDataToDBOMapper
import com.example.data.mappers.VacancyDataToDBOMapperImpl
import com.example.data.mappers.VacancyDataToDomainMapper
import com.example.data.mappers.VacancyDataToDomainMapperImpl
import com.example.data.mappers.VacancyExperienceDBOToDataMapper
import com.example.data.mappers.VacancyExperienceDBOToDataMapperImpl
import com.example.data.mappers.VacancyExperienceDTOToDataMapper
import com.example.data.mappers.VacancyExperienceDTOToDataMapperImpl
import com.example.data.mappers.VacancyExperienceDataToDBOMapper
import com.example.data.mappers.VacancyExperienceDataToDBOMapperImpl
import com.example.data.mappers.VacancyExperienceDataToDomainMapper
import com.example.data.mappers.VacancyExperienceDataToDomainMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val dataMapperModule = module {
    factoryOf(::OfferButtonDataToDomainMapperImpl) {
        bind<OfferButtonDataToDomainMapper>()
    }

    factoryOf(::OfferButtonDBOToDataMapperImpl) {
        bind<OfferButtonDBOToDataMapper>()
    }

    factoryOf(::OfferButtonDataToDBOMapperImpl) {
        bind<OfferButtonDataToDBOMapper>()
    }

    factoryOf(::OfferDataToDomainMapperImpl) {
        bind<OfferDataToDomainMapper>()
    }

    factoryOf(::OfferDTOToDataMapperImpl) {
        bind<OfferDTOToDataMapper>()
    }

    factoryOf(::OfferDBOToDataMapperImpl) {
        bind<OfferDBOToDataMapper>()
    }

    factoryOf(::OfferDataToDBOMapperImpl) {
        bind<OfferDataToDBOMapper>()
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

    factoryOf(::SalaryDBOToDataMapperImpl) {
        bind<SalaryDBOToDataMapper>()
    }

    factoryOf(::SalaryDataToDBOMapperImpl) {
        bind<SalaryDataToDBOMapper>()
    }

    factoryOf(::VacancyAddressDataToDomainMapperImpl) {
        bind<VacancyAddressDataToDomainMapper>()
    }

    factoryOf(::VacancyAddressDTOToDataMapperImpl) {
        bind<VacancyAddressDTOToDataMapper>()
    }

    factoryOf(::VacancyAddressDBOToDataMapperImpl) {
        bind<VacancyAddressDBOToDataMapper>()
    }

    factoryOf(::VacancyAddressDataToDBOMapperImpl) {
        bind<VacancyAddressDataToDBOMapper>()
    }

    factoryOf(::VacancyDataToDomainMapperImpl) {
        bind<VacancyDataToDomainMapper>()
    }

    factoryOf(::VacancyDTOToDataMapperImpl) {
        bind<VacancyDTOToDataMapper>()
    }

    factoryOf(::VacancyDBOToDataMapperImpl) {
        bind<VacancyDBOToDataMapper>()
    }

    factoryOf(::VacancyDataToDBOMapperImpl) {
        bind<VacancyDataToDBOMapper>()
    }

    factoryOf(::VacancyExperienceDataToDomainMapperImpl) {
        bind<VacancyExperienceDataToDomainMapper>()
    }

    factoryOf(::VacancyExperienceDTOToDataMapperImpl) {
        bind<VacancyExperienceDTOToDataMapper>()
    }

    factoryOf(::VacancyExperienceDBOToDataMapperImpl) {
        bind<VacancyExperienceDBOToDataMapper>()
    }

    factoryOf(::VacancyExperienceDataToDBOMapperImpl) {
        bind<VacancyExperienceDataToDBOMapper>()
    }
}