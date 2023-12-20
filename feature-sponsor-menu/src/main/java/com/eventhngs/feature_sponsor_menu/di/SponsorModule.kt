package com.eventhngs.feature_sponsor_menu.di

import com.eventhngs.feature_sponsor_menu.list.SponsorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sponsorModule = module {
    viewModel { SponsorViewModel(get()) }
}