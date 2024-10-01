package com.example.data.mappers

import com.example.api.models.VacancyDTO
import com.example.common.Mapper
import com.example.data.models.VacancyData

internal interface VacancyDTOToDataMapper : Mapper<VacancyDTO, VacancyData>
internal class VacancyDTOToDataMapperImpl(
    private val addressDTOToDataMapper: VacancyAddressDTOToDataMapper,
    private val experienceDTOToDataMapper: VacancyExperienceDTOToDataMapper,
    private val salaryDTOToDataMapper: SalaryDTOToDataMapper
) : VacancyDTOToDataMapper {
    override fun map(from: VacancyDTO): VacancyData {
        return VacancyData(
            id = from.id,
            lookingNumber = from.lookingNumber ?: 0,
            title = from.title,
            address = addressDTOToDataMapper.map(from.address),
            company = from.company,
            experience = experienceDTOToDataMapper.map(from.experience),
            publishedDate = from.publishedDate,
            isFavorite = from.isFavorite,
            salary = salaryDTOToDataMapper.map(from.salary),
            appliedNumber = from.appliedNumber,
            schedules = from.schedules,
            description = from.description,
            responsibilities = from.responsibilities,
            questions = from.questions
        )
    }
}