package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.dao.OfferDao
import com.example.database.dao.VacancyDao
import com.example.database.models.OfferDBO
import com.example.database.models.VacancyDBO
import com.example.database.utils.StringListConverter

@Database(entities = [OfferDBO::class, VacancyDBO::class], version = 1)
@TypeConverters(StringListConverter::class)
internal abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun offerDao(): OfferDao

    abstract fun vacancyDao(): VacancyDao
}

class AppDatabase internal constructor(
    private val db: AppRoomDatabase
) {
    val offersDao: OfferDao
        get() = db.offerDao()

    val vacanciesDao: VacancyDao
        get() = db.vacancyDao()
}

fun ProvideAppDatabase(applicationContext: Context): AppDatabase {
    val db = Room.databaseBuilder(
        applicationContext.applicationContext,
        AppRoomDatabase::class.java,
        "app_database"
    )
        .build()
    return AppDatabase(db)
}