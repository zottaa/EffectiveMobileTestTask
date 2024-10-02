package com.example.data.mappers

import com.example.data.models.VacancyData
import com.example.database.models.VacancyDBO

internal interface VacancyDataToDBOMapper {
    fun map(from: VacancyData): VacancyDBO
}

internal class VacancyDataToDBOMapperImpl(
    private val vacancyAddressDataToDBOMapper: VacancyAddressDataToDBOMapper,
    private val vacancyExperienceDataToDBOMapper: VacancyExperienceDataToDBOMapper,
    private val salaryDataToDBOMapper: SalaryDataToDBOMapper
) : VacancyDataToDBOMapper {
    override fun map(from: VacancyData): VacancyDBO {
        return VacancyDBO(
            id = from.id,
            lookingNumber = from.lookingNumber,
            title = from.title,
            address = vacancyAddressDataToDBOMapper.map(from.address),
            company = from.company,
            experience = vacancyExperienceDataToDBOMapper.map(from.experience),
            publishedDate = from.publishedDate,
            isFavorite = from.isFavorite,
            salary = salaryDataToDBOMapper.map(from.salary),
            appliedNumber = from.appliedNumber,
            schedules = from.schedules,
            description = from.description,
            responsibilities = from.responsibilities,
            questions = from.questions
        )
    }
}

