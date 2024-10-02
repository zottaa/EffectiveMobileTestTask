package com.example.data.di

import com.example.database.ProvideAppDatabase
import org.koin.dsl.module

internal val databaseModule = module {
    single {
        ProvideAppDatabase(applicationContext = get())
    }
}