package com.example.data.mappers

import com.example.data.models.VacancyData
import com.example.database.models.VacancyDBO

internal interface VacancyDBOToDataMapper {
    fun map(from: VacancyDBO): VacancyData
}

internal class VacancyDBOToDataMapperImpl(
    private val vacancyAddressDBOToDataMapper: VacancyAddressDBOToDataMapper,
    private val vacancyExperienceDBOToDataMapper: VacancyExperienceDBOToDataMapper,
    private val salaryDBOToDataMapper: SalaryDBOToDataMapper
) : VacancyDBOToDataMapper {
    override fun map(from: VacancyDBO): VacancyData {
        return VacancyData(
            id = from.id,
            lookingNumber = from.lookingNumber ?: 0,
            title = from.title,
            address = vacancyAddressDBOToDataMapper.map(from.address),
            company = from.company,
            experience = vacancyExperienceDBOToDataMapper.map(from.experience),
            publishedDate = from.publishedDate,
            isFavorite = from.isFavorite,
            salary = salaryDBOToDataMapper.map(from.salary),
            appliedNumber = from.appliedNumber,
            schedules = from.schedules,
            description = from.description,
            responsibilities = from.responsibilities,
            questions = from.questions
        )
    }
}
