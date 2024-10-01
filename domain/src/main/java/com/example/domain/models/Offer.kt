package com.example.domain.models

data class Offer(
    val id: String? = null,
    val title: String,
    val button: OfferButton? = null,
    val link: String
)

data class OfferButton(
    val text: String
)