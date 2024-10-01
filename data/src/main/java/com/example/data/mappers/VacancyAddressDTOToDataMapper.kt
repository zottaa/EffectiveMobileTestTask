package com.example.data.mappers

import com.example.api.models.VacancyAddressDTO
import com.example.common.Mapper
import com.example.data.models.VacancyAddressData

internal interface VacancyAddressDTOToDataMapper : Mapper<VacancyAddressDTO, VacancyAddressData>
internal class VacancyAddressDTOToDataMapperImpl : VacancyAddressDTOToDataMapper {
    override fun map(from: VacancyAddressDTO): VacancyAddressData {
        return VacancyAddressData(
            town = from.town,
            street = from.street,
            house = from.house
        )
    }
}