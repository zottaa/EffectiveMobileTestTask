package com.example.presentation.mappers

import com.example.common.Mapper
import com.example.domain.models.Salary
import com.example.presentation.models.SalaryUi

internal interface SalaryDomainToUiMapper : Mapper<Salary, SalaryUi>
internal class SalaryDomainToUiMapperImpl : SalaryDomainToUiMapper {
    override fun map(from: Salary): SalaryUi {
        return SalaryUi(
            full = from.full,
            short = from.short
        )
    }
}