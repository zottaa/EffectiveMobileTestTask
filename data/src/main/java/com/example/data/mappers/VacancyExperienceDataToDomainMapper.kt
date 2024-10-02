package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.VacancyExperienceData
import com.example.domain.models.VacancyExperience

internal interface VacancyExperienceDataToDomainMapper :
    Mapper<VacancyExperienceData, VacancyExperience>

internal class VacancyExperienceDataToDomainMapperImpl :
    VacancyExperienceDataToDomainMapper {
    override fun map(from: VacancyExperienceData): VacancyExperience {
        return VacancyExperience(
            previewText = from.previewText,
            text = from.text
        )
    }
}