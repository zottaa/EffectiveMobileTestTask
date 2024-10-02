package com.example.data.mappers

import com.example.data.models.SalaryData
import com.example.database.models.SalaryDBO

internal interface SalaryDBOToDataMapper {
    fun map(from: SalaryDBO): SalaryData
}

internal class SalaryDBOToDataMapperImpl : SalaryDBOToDataMapper {
    override fun map(from: SalaryDBO): SalaryData {
        return SalaryData(
            full = from.full,
            short = from.short
        )
    }
}