package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.Vacancy
import com.example.presentation.models.VacancyUi

internal interface VacancyDomainToUiMapper : Mapper<Vacancy, VacancyUi>
internal class VacancyDomainToUiMapperImpl(
    private val addressDomainToUiMapper: VacancyAddressDomainToUiMapper,
    private val experienceDomainToUiMapper: VacancyExperienceDomainToUiMapper,
    private val salaryDomainToUiMapper: SalaryDomainToUiMapper
) : VacancyDomainToUiMapper {
    override fun map(from: Vacancy): VacancyUi {
        return VacancyUi(
            id = from.id,
            lookingNumber = from.lookingNumber,
            title = from.title,
            address = addressDomainToUiMapper.map(from.address),
            company = from.company,
            experience = experienceDomainToUiMapper.map(from.experience),
            publishedDate = from.publishedDate,
            isFavorite = from.isFavorite,
            salary = from.salary?.let { salaryDomainToUiMapper.map(it) },
            appliedNumber = from.appliedNumber,
            schedules = from.schedules,
            description = from.description,
            responsibilities = from.responsibilities,
            questions = from.questions
        )
    }
}