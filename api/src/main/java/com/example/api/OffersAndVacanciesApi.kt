package com.example.api

import com.example.api.models.OffersAndVacanciesDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.UnknownHostException

class OffersAndVacanciesApi(
    baseUrl: String
) {
    private val instance: OffersAndVacanciesApiService

    init {
        instance = retrofit(baseUrl).create()
    }

    private fun retrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun fetch(): OffersAndVacanciesResult {
        return try {
            val response = instance.fetch()
            OffersAndVacanciesResult.Success(response)
        } catch (noInternetException: UnknownHostException) {
            OffersAndVacanciesResult.Error("No internet connection")
        }
    }
}

fun ProvideOffersAndVacanciesApi(
    baseUrl: String
): OffersAndVacanciesApi = OffersAndVacanciesApi(baseUrl)

sealed class OffersAndVacanciesResult {
    data class Success(
        val offersAndVacancies: OffersAndVacanciesDTO
    ) : OffersAndVacanciesResult()

    data class Error(
        val errorMessage: String
    ) : OffersAndVacanciesResult()
}