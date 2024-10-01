package com.example.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferDTO(
    @SerialName("id")
    val id: String? = null,
    @SerialName("title")
    val title: String,
    @SerialName("button")
    val button: OfferButtonDTO? = null,
    @SerialName("link")
    val link: String
)

@Serializable
data class OfferButtonDTO(
    @SerialName("text")
    val text: String
)