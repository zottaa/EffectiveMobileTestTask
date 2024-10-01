package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.OfferData
import com.example.domain.models.Offer

internal interface OfferDataToDomainMapper : Mapper<OfferData, Offer>

internal class OfferDataToDomainMapperImpl(
    private val buttonMapper: OfferButtonDataToDomainMapper
) : OfferDataToDomainMapper {
    override fun map(from: OfferData): Offer {
        return Offer(
            id = from.id,
            title = from.title,
            button = from.button?.let { buttonMapper.map(it) },
            link = from.link
        )
    }
}