package com.example.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    object Main

    @Serializable
    object Favorite

    @Serializable
    object Stub
}