package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.OffersAndVacanciesData
import com.example.domain.models.OffersAndVacancies

internal interface OffersAndVacanciesDataToDomainMapper :
    Mapper<OffersAndVacanciesData, OffersAndVacancies>

internal class OffersAndVacanciesDataToDomainMapperImpl(
    private val vacancyDataToDomainMapper: VacancyDataToDomainMapper,
    private val offerDataToDomainMapper: OfferDataToDomainMapper
) : OffersAndVacanciesDataToDomainMapper {
    override fun map(from: OffersAndVacanciesData): OffersAndVacancies {
        return OffersAndVacancies(
            from.offers.map { offerDataToDomainMapper.map(it) },
            from.vacancies.map { vacancyDataToDomainMapper.map(it) }
        )
    }
}
