package com.eventhngs.domain.di

import com.eventhngs.domain.interactor.EventhngsInteractor
import com.eventhngs.domain.interactor.EventhngsPagingInteractor
import com.eventhngs.domain.interactor.UserPreferenceInteractor
import com.eventhngs.domain.usecase.EventhngsPagingUseCase
import com.eventhngs.domain.usecase.EventhngsUseCase
import com.eventhngs.domain.usecase.SettingsPreferenceInteractor
import com.eventhngs.domain.usecase.SettingsPreferenceUseCase
import com.eventhngs.domain.usecase.UserPreferenceUseCase
import org.koin.dsl.module

val domainModule = module {
    single<EventhngsUseCase> { EventhngsInteractor(get()) }
    single<EventhngsPagingUseCase> { EventhngsPagingInteractor(get()) }
    single<UserPreferenceUseCase> { UserPreferenceInteractor(get()) }
    single<SettingsPreferenceUseCase> { SettingsPreferenceInteractor(get()) }
}