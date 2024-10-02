package com.example.data.mappers

import com.example.data.models.OfferData
import com.example.database.models.OfferDBO

internal interface OfferDataToDBOMapper {
    fun map(from: OfferData): OfferDBO
}

internal class OfferDataToDBOMapperImpl(
    private val offerButtonDataToDBOMapper: OfferButtonDataToDBOMapper
) : OfferDataToDBOMapper {
    override fun map(from: OfferData): OfferDBO {
        return OfferDBO(
            id = from.id ?: "",
            title = from.title,
            button = from.button?.let { offerButtonDataToDBOMapper.map(it) },
            link = from.link
        )
    }
}