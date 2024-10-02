package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.OfferButtonData
import com.example.domain.models.OfferButton

internal interface OfferButtonDataToDomainMapper : Mapper<OfferButtonData, OfferButton>

internal class OfferButtonDataToDomainMapperImpl : OfferButtonDataToDomainMapper {
    override fun map(from: OfferButtonData): OfferButton {
        return OfferButton(text = from.text)
    }
}