package com.eventhngs.data.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.eventhngs.data.EventhngsRepositoryImpl
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.data.remote.service.EventhngsService
import com.eventhngs.domain.repository.EventhngsRepository
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<OkHttpClient>(named("chucker")) {
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(get()))
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(get<OkHttpClient>(named("chucker")))
            .build()
    }

    single<EventhngsService> {
        get<Retrofit>().create(EventhngsService::class.java)
    }

    single { RemoteDataSource(get()) }

    single<EventhngsRepository> { EventhngsRepositoryImpl(get()) }

}