package com.example.data.mappers

import com.example.api.models.SalaryDTO
import com.example.common.Mapper
import com.example.data.models.SalaryData

internal interface SalaryDTOToDataMapper : Mapper<SalaryDTO, SalaryData>
internal class SalaryDTOToDataMapperImpl : SalaryDTOToDataMapper {
    override fun map(from: SalaryDTO): SalaryData {
        return SalaryData(
            full = from.full,
            short = from.short
        )
    }
}