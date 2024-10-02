package com.example.data.mappers

import com.example.api.models.OffersAndVacanciesDTO
import com.example.common.Mapper
import com.example.data.models.OffersAndVacanciesData

internal interface OffersAndVacanciesDTOToDataMapper :
    Mapper<OffersAndVacanciesDTO, OffersAndVacanciesData>

internal class OffersAndVacanciesDTOToDataMapperImpl(
    private val offerDTOToDataMapper: OfferDTOToDataMapper,
    private val vacancyDTOToDataMapper: VacancyDTOToDataMapper
) : OffersAndVacanciesDTOToDataMapper {
    override fun map(from: OffersAndVacanciesDTO): OffersAndVacanciesData {
        return OffersAndVacanciesData(
            offers = from.offers.map { offerDTOToDataMapper.map(it) },
            vacancies = from.vacancies.map { vacancyDTOToDataMapper.map(it) }
        )
    }
}

