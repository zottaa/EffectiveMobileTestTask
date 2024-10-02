package com.example.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offers")
data class OfferDBO(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @Embedded("offer_button_")
    val button: OfferButtonDBO?,
    @ColumnInfo(name = "link")
    val link: String
)

data class OfferButtonDBO(
    @ColumnInfo(name = "text")
    val text: String
)