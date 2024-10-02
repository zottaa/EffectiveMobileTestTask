package com.example.data

import com.example.api.OffersAndVacanciesApi
import com.example.api.OffersAndVacanciesResult
import com.example.data.mappers.OfferDBOToDataMapper
import com.example.data.mappers.OfferDataToDBOMapper
import com.example.data.mappers.OffersAndVacanciesDTOToDataMapper
import com.example.data.mappers.OffersAndVacanciesDataToDomainMapper
import com.example.data.mappers.VacancyDBOToDataMapper
import com.example.data.mappers.VacancyDataToDBOMapper
import com.example.data.mappers.VacancyDataToDBOMapperImpl
import com.example.data.models.OfferData
import com.example.data.models.OffersAndVacanciesData
import com.example.data.models.VacancyData
import com.example.database.AppDatabase
import com.example.domain.OffersAndVacanciesRepository
import com.example.domain.models.Offer
import com.example.domain.models.OffersAndVacancies
import com.example.domain.models.Vacancy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class OffersAndVacanciesRepositoryImpl(
    private val api: OffersAndVacanciesApi,
    private val db: AppDatabase,
    private val offersAndVacanciesDTOToDataMapper: OffersAndVacanciesDTOToDataMapper,
    private val offersAndVacanciesDataToDomainMapper: OffersAndVacanciesDataToDomainMapper,
    private val offerDataToDBOMapper: OfferDataToDBOMapper,
    private val vacancyDataToDBOMapper: VacancyDataToDBOMapper,
    private val offerDBOToDataMapper: OfferDBOToDataMapper,
    private val vacancyDBOToDataMapper: VacancyDBOToDataMapper
) : OffersAndVacanciesRepository {
    override fun getOffersAndVacancies(): Flow<OffersAndVacancies> {
        return flow {
            val offersAndVacanciesFromDb = OffersAndVacanciesData(
                offers = db.offersDao.getAllOffers().map { offerDBOToDataMapper.map(it) },
                vacancies = db.vacanciesDao.getAllVacancies().map { vacancyDBOToDataMapper.map(it) }
            )
            emit(offersAndVacanciesDataToDomainMapper.map(offersAndVacanciesFromDb))
            when (val result = api.fetch()) {
                is OffersAndVacanciesResult.Error -> throw Exception(result.errorMessage)
                is OffersAndVacanciesResult.Success -> {
                    val offersAndVacanciesFromApi =
                        offersAndVacanciesDTOToDataMapper.map(result.offersAndVacancies)
                    val updatedOffersAndVacancies =
                        getUpdatedOffersAndVacancies(
                            offersAndVacanciesFromApi,
                            offersAndVacanciesFromDb
                        )
                    emit(
                        offersAndVacanciesDataToDomainMapper.map(
                            updatedOffersAndVacancies
                        )
                    )
                    updateDatabase(updatedOffersAndVacancies)
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun changeFavoriteStatus(vacancyId: String) {
        withContext(Dispatchers.IO) {
            val vacancy = db.vacanciesDao.getVacancyById(vacancyId)
            if (vacancy != null) {
                val updatedVacancy = vacancy.copy(isFavorite = !vacancy.isFavorite)
                db.vacanciesDao.insertOrUpdateVacancy(updatedVacancy)
            }
        }
    }

    private fun getUpdatedOffersAndVacancies(
        offersAndVacanciesFromApi: OffersAndVacanciesData,
        offersAndVacanciesFromDb: OffersAndVacanciesData
    ): OffersAndVacanciesData {
        val updatedVacancies = updateVacanciesWithFavorites(
            vacanciesFromApi = offersAndVacanciesFromApi.vacancies,
            vacanciesFromDb = offersAndVacanciesFromDb.vacancies
        )
        val updatedOffersAndVacancies = OffersAndVacanciesData(
            offers = offersAndVacanciesFromApi.offers,
            vacancies = updatedVacancies
        )
        return updatedOffersAndVacancies
    }

    /**
     * Обновляет список вакансий, полученных из API, с учетом статуса "избранное" (isFavorite),
     * используя данные из базы данных.
     *
     * Поскольку в текущей реализации отсутствует возможность изменение статуса "избранное"
     * непосредственно из API, мы вынуждены использовать данные из локальной базы данных,
     * чтобы обеспечить актуальность этого поля.
     *
     * @param vacanciesFromApi Список вакансий, полученных из API.
     * @param vacanciesFromDb Список вакансий, полученных из базы данных.
     * @return Обновленный список вакансий с учетом статуса "избранное".
     */
    private fun updateVacanciesWithFavorites(
        vacanciesFromApi: List<VacancyData>,
        vacanciesFromDb: List<VacancyData>
    ): List<VacancyData> {
        val dbVacancyMap = vacanciesFromDb.associateBy { it.id }

        return vacanciesFromApi.map { apiVacancy ->
            val dbVacancy = dbVacancyMap[apiVacancy.id]

            if (dbVacancy != null) {
                apiVacancy.copy(isFavorite = dbVacancy.isFavorite)
            } else {
                apiVacancy
            }
        }
    }

    private suspend fun updateDatabase(updatedOffersAndVacancies: OffersAndVacanciesData) {
        db.offersDao.insertOrUpdateOffers(updatedOffersAndVacancies.offers.map {
            offerDataToDBOMapper.map(
                it
            )
        })
        db.vacanciesDao.insertOrUpdateVacancies(updatedOffersAndVacancies.vacancies.map {
            vacancyDataToDBOMapper.map(
                it
            )
        })
    }
}