package com.example.data.mappers

import com.example.api.models.VacancyExperienceDTO
import com.example.common.Mapper
import com.example.data.models.VacancyExperienceData

internal interface VacancyExperienceDTOToDataMapper :
    Mapper<VacancyExperienceDTO, VacancyExperienceData>

internal class VacancyExperienceDTOToDataMapperImpl : VacancyExperienceDTOToDataMapper {
    override fun map(from: VacancyExperienceDTO): VacancyExperienceData {
        return VacancyExperienceData(
            previewText = from.previewText,
            text = from.text
        )
    }
}