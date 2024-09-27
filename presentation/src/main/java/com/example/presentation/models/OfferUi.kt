package com.example.presentation.models

import com.example.presentation.uikit.IconType

data class OfferUi(
    val id: String? = null,
    val iconType: IconType? = null,
    val title: String,
    val button: OfferButtonUi? = null,
    val link: String
)

data class OfferButtonUi(
    val text: String
)