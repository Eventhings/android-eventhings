package com.eventhngs.feature_home.di

import com.eventhngs.feature_home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}