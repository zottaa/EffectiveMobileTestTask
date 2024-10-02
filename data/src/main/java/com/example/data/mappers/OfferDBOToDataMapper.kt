package com.example.data.mappers

import com.example.data.models.OfferData
import com.example.database.models.OfferDBO

internal interface OfferDBOToDataMapper {
    fun map(from: OfferDBO): OfferData
}

internal class OfferDBOToDataMapperImpl(
    private val offerButtonDBOToDataMapper: OfferButtonDBOToDataMapper
) : OfferDBOToDataMapper {
    override fun map(from: OfferDBO): OfferData {
        return OfferData(
            id = from.id.toString(),
            title = from.title,
            button = from.button?.let { offerButtonDBOToDataMapper.map(it) },
            link = from.link
        )
    }
}