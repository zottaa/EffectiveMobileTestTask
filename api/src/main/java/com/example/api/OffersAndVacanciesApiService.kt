package com.example.api

import com.example.api.models.OffersAndVacanciesDTO
import retrofit2.http.GET

interface OffersAndVacanciesApiService {
    @GET("refs/heads/master/%D0%BC%D0%BE%D0%BA%20json.json")
    suspend fun fetch(): OffersAndVacanciesDTO
}

