package com.eventhngs.feature_media_partner_menu.di

import com.eventhngs.feature_media_partner_menu.list.MediaPartnerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mediaPartnerModule = module {
    viewModel { MediaPartnerViewModel(get()) }
}