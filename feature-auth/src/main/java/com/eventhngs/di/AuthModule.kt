package com.eventhngs.di

import com.eventhngs.feature_auth.login.LoginViewModel
import com.eventhngs.feature_auth.register.RegisterViewModel
import com.eventhngs.splashscreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { SplashScreenViewModel(get()) }
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { RegisterViewModel(get()) }
}