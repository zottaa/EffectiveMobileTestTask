package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.VacancyAddressData
import com.example.domain.models.VacancyAddress

internal interface VacancyAddressDataToDomainMapper :
    Mapper<VacancyAddressData, VacancyAddress>

internal class VacancyAddressDataToDomainMapperImpl :
    VacancyAddressDataToDomainMapper {
    override fun map(from: VacancyAddressData): VacancyAddress {
        return VacancyAddress(
            town = from.town,
            street = from.street,
            house = from.house
        )
    }
}