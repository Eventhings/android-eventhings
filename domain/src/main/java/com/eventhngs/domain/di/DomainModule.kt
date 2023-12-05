package com.eventhngs.domain.di

import com.eventhngs.domain.interactor.EventhngsInteractor
import com.eventhngs.domain.usecase.EventhngsUseCase
import org.koin.dsl.module

val domainModule = module {
    single<EventhngsUseCase> { EventhngsInteractor(get()) }
}