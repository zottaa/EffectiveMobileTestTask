package com.example.presentation.navigation

import kotlinx.serialization.Serializable


internal sealed interface BottomTabDestinations {
    @Serializable
    object Search : BottomTabDestinations

    @Serializable
    object Favorite : BottomTabDestinations

    @Serializable
    object Responses : BottomTabDestinations

    @Serializable
    object Messages : BottomTabDestinations

    @Serializable
    object Profile : BottomTabDestinations
}