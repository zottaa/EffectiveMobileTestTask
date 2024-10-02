package com.example.data.mappers

import com.example.data.models.VacancyExperienceData
import com.example.database.models.VacancyExperienceDBO

internal interface VacancyExperienceDataToDBOMapper {
    fun map(from: VacancyExperienceData): VacancyExperienceDBO
}

internal class VacancyExperienceDataToDBOMapperImpl : VacancyExperienceDataToDBOMapper {
    override fun map(from: VacancyExperienceData): VacancyExperienceDBO {
        return VacancyExperienceDBO(
            previewText = from.previewText,
            text = from.text
        )
    }
}