package com.example.data.mappers

import com.example.api.models.OfferDTO
import com.example.common.Mapper
import com.example.data.models.OfferButtonData
import com.example.data.models.OfferData

internal interface OfferDTOToDataMapper : Mapper<OfferDTO, OfferData>
internal class OfferDTOToDataMapperImpl : OfferDTOToDataMapper {
    override fun map(from: OfferDTO): OfferData {
        return OfferData(
            id = from.id,
            title = from.title,
            button = from.button?.let { OfferButtonData(it.text) },
            link = from.link
        )
    }
}