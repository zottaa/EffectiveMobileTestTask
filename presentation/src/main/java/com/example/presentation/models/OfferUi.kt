package com.example.presentation.models

import com.example.presentation.uikit.IconType

internal data class OfferUi(
    val id: String? = null,
    val iconType: IconType? = null,
    val title: String,
    val button: OfferButtonUi? = null,
    val link: String
)

internal data class OfferButtonUi(
    val text: String
)