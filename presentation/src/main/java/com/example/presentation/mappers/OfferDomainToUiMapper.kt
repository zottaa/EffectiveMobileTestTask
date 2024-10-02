package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.Offer
import com.example.presentation.models.OfferButtonUi
import com.example.presentation.models.OfferUi
import com.example.presentation.uikit.IconType

internal interface OfferDomainToUiMapper : Mapper<Offer, OfferUi>
internal class OfferDomainToUiMapperImpl : OfferDomainToUiMapper {
    override fun map(from: Offer): OfferUi {
        return OfferUi(
            id = from.id,
            iconType = when (from.id) {
                "near_vacancies" -> IconType.NearVacancies
                "level_up_resume" -> IconType.LevelUpResume
                "temporary_job" -> IconType.TemporaryJob
                else -> null
            },
            title = from.title,
            button = from.button?.let { OfferButtonUi(it.text) },
            link = from.link
        )
    }
}