package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.VacancyExperience
import com.example.presentation.models.VacancyExperienceUi

internal interface VacancyExperienceDomainToUiMapper :
    Mapper<VacancyExperience, VacancyExperienceUi>

internal class VacancyExperienceDomainToUiMapperImpl : VacancyExperienceDomainToUiMapper {
    override fun map(from: VacancyExperience): VacancyExperienceUi {
        return VacancyExperienceUi(
            previewText = from.previewText,
            text = from.text
        )
    }
}