package com.eventhngs.splashscreen

import androidx.lifecycle.ViewModel
import com.eventhngs.domain.usecase.SettingsPreferenceUseCase

class SplashScreenViewModel(
    private val settingsPreferenceUseCase: SettingsPreferenceUseCase
) : ViewModel() {

    val isLogging get() = settingsPreferenceUseCase.isLogging

}