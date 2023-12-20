package com.eventhngs.data.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.eventhngs.data.BuildConfig
import com.eventhngs.data.EventhngsPagingRepositoryImpl
import com.eventhngs.data.EventhngsRepositoryImpl
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.data.remote.service.EventhngsService
import com.eventhngs.domain.repository.EventhngsPagingRepository
import com.eventhngs.domain.repository.EventhngsRepository
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<Interceptor>(named("app-token")) {
        Interceptor { chain ->
            val req = chain.request()
            val requestHeaders = req.newBuilder()
                .addHeader("x-app-token", BuildConfig.APP_TOKEN)
                .build()
            chain.proceed(requestHeaders)
        }
    }

    single<OkHttpClient>(named("client")) {
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(get()))
            .addInterceptor(get<Interceptor>(named("app-token")))
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(get<OkHttpClient>(named("client")))
            .build()
    }

    single<EventhngsService> {
        get<Retrofit>().create(EventhngsService::class.java)
    }

    single { RemoteDataSource(get()) }

    single<EventhngsRepository> { EventhngsRepositoryImpl(get()) }

    single<EventhngsPagingRepository> { EventhngsPagingRepositoryImpl(get()) }

}