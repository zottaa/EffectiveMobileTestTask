package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.models.OfferDBO

@Dao
interface OfferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateOffer(offer: OfferDBO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateOffers(offers: List<OfferDBO>)

    @Query("SELECT * FROM offers")
    suspend fun getAllOffers(): List<OfferDBO>
}