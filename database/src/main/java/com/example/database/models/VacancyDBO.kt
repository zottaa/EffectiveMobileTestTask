package com.example.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.database.utils.StringListConverter

@Entity(tableName = "vacancies")
data class VacancyDBO(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "looking_number")
    val lookingNumber: Int?,

    @ColumnInfo(name = "title")
    val title: String,

    @Embedded(prefix = "address_")
    val address: VacancyAddressDBO,

    @ColumnInfo(name = "company")
    val company: String,

    @Embedded(prefix = "experience_")
    val experience: VacancyExperienceDBO,

    @ColumnInfo(name = "published_date")
    val publishedDate: String,

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean,

    @Embedded(prefix = "salary_")
    val salary: SalaryDBO,

    @ColumnInfo(name = "applied_number")
    val appliedNumber: Int?,

    @TypeConverters(StringListConverter::class)
    @ColumnInfo(name = "schedules")
    val schedules: List<String>,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "responsibilities")
    val responsibilities: String?,

    @TypeConverters(StringListConverter::class)
    @ColumnInfo(name = "questions")
    val questions: List<String>
)

data class VacancyAddressDBO(
    @ColumnInfo(name = "town")
    val town: String,

    @ColumnInfo(name = "street")
    val street: String,

    @ColumnInfo(name = "house")
    val house: String
)

data class VacancyExperienceDBO(
    @ColumnInfo(name = "preview_text")
    val previewText: String,

    @ColumnInfo(name = "text")
    val text: String
)

data class SalaryDBO(
    @ColumnInfo(name = "full")
    val full: String,

    @ColumnInfo(name = "short")
    val short: String?
)