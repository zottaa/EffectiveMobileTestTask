package com.example.data.mappers

import com.example.data.models.OfferButtonData
import com.example.database.models.OfferButtonDBO

internal interface OfferButtonDBOToDataMapper {
    fun map(from: OfferButtonDBO): OfferButtonData
}

internal class OfferButtonDBOToDataMapperImpl : OfferButtonDBOToDataMapper {
    override fun map(from: OfferButtonDBO): OfferButtonData {
        return OfferButtonData(
            text = from.text
        )
    }
}