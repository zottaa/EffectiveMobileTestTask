package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.VacancyData
import com.example.domain.models.Vacancy

internal interface VacancyDataToDomainMapper : Mapper<VacancyData, Vacancy>

internal class VacancyDataToDomainMapperImpl(
    private val addressMapper: VacancyAddressDataToDomainMapper,
    private val experienceMapper: VacancyExperienceDataToDomainMapper,
    private val salaryMapper: SalaryDataToDomainMapper
) : VacancyDataToDomainMapper {
    override fun map(from: VacancyData): Vacancy {
        return Vacancy(
            id = from.id,
            lookingNumber = from.lookingNumber,
            title = from.title,
            address = addressMapper.map(from.address),
            company = from.company,
            experience = experienceMapper.map(from.experience),
            publishedDate = from.publishedDate,
            isFavorite = from.isFavorite,
            salary = salaryMapper.map(from.salary),
            appliedNumber = from.appliedNumber,
            schedules = from.schedules,
            description = from.description,
            responsibilities = from.responsibilities,
            questions = from.questions
        )
    }
}