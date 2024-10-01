package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.VacancyAddress
import com.example.presentation.models.VacancyAddressUi

internal interface VacancyAddressDomainToUiMapper : Mapper<VacancyAddress, VacancyAddressUi>
internal class VacancyAddressDomainToUiMapperImpl : VacancyAddressDomainToUiMapper {
    override fun map(from: VacancyAddress): VacancyAddressUi {
        return VacancyAddressUi(
            town = from.town,
            street = from.street,
            house = from.house
        )
    }
}