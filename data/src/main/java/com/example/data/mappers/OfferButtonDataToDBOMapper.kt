package com.example.data.mappers

import com.example.data.models.OfferButtonData
import com.example.database.models.OfferButtonDBO

internal interface OfferButtonDataToDBOMapper {
    fun map(from: OfferButtonData): OfferButtonDBO
}

internal class OfferButtonDataToDBOMapperImpl : OfferButtonDataToDBOMapper {
    override fun map(from: OfferButtonData): OfferButtonDBO {
        return OfferButtonDBO(
            text = from.text
        )
    }
}