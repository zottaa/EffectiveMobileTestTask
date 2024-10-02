package com.example.data.mappers

import com.example.data.models.SalaryData
import com.example.database.models.SalaryDBO

internal interface SalaryDataToDBOMapper {
    fun map(from: SalaryData): SalaryDBO
}

internal class SalaryDataToDBOMapperImpl : SalaryDataToDBOMapper {
    override fun map(from: SalaryData): SalaryDBO {
        return SalaryDBO(
            full = from.full,
            short = from.short
        )
    }
}