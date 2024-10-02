package com.example.data.models

internal data class OfferData(
    val id: String? = null,
    val title: String,
    val button: OfferButtonData? = null,
    val link: String
)

internal data class OfferButtonData(
    val text: String
)