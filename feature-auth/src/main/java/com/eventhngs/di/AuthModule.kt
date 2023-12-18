package com.eventhngs.di

import com.eventhngs.feature_auth.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel {
        LoginViewModel(get())
    }
}