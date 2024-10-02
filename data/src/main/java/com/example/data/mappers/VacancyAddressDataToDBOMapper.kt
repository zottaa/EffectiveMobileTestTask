package com.example.data.mappers

import com.example.data.models.VacancyAddressData
import com.example.database.models.VacancyAddressDBO

internal interface VacancyAddressDataToDBOMapper {
    fun map(from: VacancyAddressData): VacancyAddressDBO
}

internal class VacancyAddressDataToDBOMapperImpl : VacancyAddressDataToDBOMapper {
    override fun map(from: VacancyAddressData): VacancyAddressDBO {
        return VacancyAddressDBO(
            town = from.town,
            street = from.street,
            house = from.house
        )
    }
}