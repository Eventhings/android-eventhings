package com.eventhngs.feature_all_menu

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val allMenuModule = module {
    viewModel { AllMenuViewModel(get()) }
}