package com.example.data.mappers

import com.example.common.Mapper
import com.example.data.models.SalaryData
import com.example.domain.models.Salary

internal interface SalaryDataToDomainMapper : Mapper<SalaryData, Salary>

internal class SalaryDataToDomainMapperImpl : SalaryDataToDomainMapper {
    override fun map(from: SalaryData): Salary {
        return Salary(
            full = from.full,
            short = from.short
        )
    }
}