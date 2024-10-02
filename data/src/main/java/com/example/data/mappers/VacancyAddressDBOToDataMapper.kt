package com.example.data.mappers

import com.example.data.models.VacancyAddressData
import com.example.database.models.VacancyAddressDBO

internal interface VacancyAddressDBOToDataMapper {
    fun map(from: VacancyAddressDBO): VacancyAddressData
}

internal class VacancyAddressDBOToDataMapperImpl : VacancyAddressDBOToDataMapper {
    override fun map(from: VacancyAddressDBO): VacancyAddressData {
        return VacancyAddressData(
            town = from.town,
            street = from.street,
            house = from.house
        )
    }
}