package com.example.data.models

data class OfferData(
    val id: String? = null,
    val title: String,
    val button: OfferButtonData? = null,
    val link: String
)

data class OfferButtonData(
    val text: String
)