package com.example.data

import com.example.api.OffersAndVacanciesApi
import com.example.api.OffersAndVacanciesResult
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapper
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapper
import com.example.data.models.OfferData
import com.example.domain.OffersAndVacanciesRepository
import com.example.domain.models.Offer
import com.example.domain.models.OffersAndVacancies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class OffersAndVacanciesRepositoryImpl(
    private val api: OffersAndVacanciesApi,
    private val offersAndVacanciesDTOToDataMapper: OffersAndVacanciesDTOToDataMapper,
    private val offersAndVacanciesDataToDomainMapper: OffersAndVacanciesDataToDomainMapper
) : OffersAndVacanciesRepository {
    override fun getOffersAndVacancies(): Flow<OffersAndVacancies> {
        return flow {
            when (val result = api.fetch()) {
                //TODO error handling
                is OffersAndVacanciesResult.Error -> throw Exception(result.errorMessage)
                is OffersAndVacanciesResult.Success -> {
                    emit(
                        offersAndVacanciesDataToDomainMapper.map(
                            offersAndVacanciesDTOToDataMapper.map(result.offersAndVacancies)
                        )
                    )
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}