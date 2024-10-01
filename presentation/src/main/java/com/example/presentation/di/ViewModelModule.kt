package com.example.presentation.di

import com.example.presentation.screen.favorite.FavoriteViewModel
import com.example.presentation.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::MainViewModel)
    viewModelOf(::FavoriteViewModel)
}