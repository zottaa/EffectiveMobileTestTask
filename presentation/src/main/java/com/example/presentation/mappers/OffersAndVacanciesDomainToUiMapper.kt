package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.OffersAndVacancies
import com.example.presentation.models.OffersAndVacanciesUi

internal interface OffersAndVacanciesDomainToUiMapper :
    Mapper<OffersAndVacancies, OffersAndVacanciesUi>

internal class OffersAndVacanciesDomainToUiMapperImpl(
    private val offerDomainToUiMapper: OfferDomainToUiMapper,
    private val vacancyDomainToUiMapper: VacancyDomainToUiMapper,
) : OffersAndVacanciesDomainToUiMapper {
    override fun map(from: OffersAndVacancies): OffersAndVacanciesUi {
        return OffersAndVacanciesUi(
            offers = from.offers.map { offerDomainToUiMapper.map(it) },
            vacancies = from.vacancies.map {
                vacancyDomainToUiMapper.map(
                    it
                )
            }
        )
    }
}

