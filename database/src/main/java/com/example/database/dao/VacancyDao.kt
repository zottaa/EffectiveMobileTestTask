package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.models.VacancyDBO

@Dao
interface VacancyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVacancy(vacancy: VacancyDBO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVacancies(vacancies: List<VacancyDBO>)

    @Query("SELECT * FROM vacancies")
    suspend fun getAllVacancies(): List<VacancyDBO>

    @Query("SELECT * FROM vacancies WHERE id = :id")
    suspend fun getVacancyById(id: String): VacancyDBO?
}