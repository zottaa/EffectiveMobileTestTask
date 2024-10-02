package com.example.data.mappers

import com.example.data.models.VacancyExperienceData
import com.example.database.models.VacancyExperienceDBO

internal interface VacancyExperienceDBOToDataMapper {
    fun map(from: VacancyExperienceDBO): VacancyExperienceData
}

internal class VacancyExperienceDBOToDataMapperImpl : VacancyExperienceDBOToDataMapper {
    override fun map(from: VacancyExperienceDBO): VacancyExperienceData {
        return VacancyExperienceData(
            previewText = from.previewText,
            text = from.text
        )
    }
}