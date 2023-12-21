package com.eventhngs.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.eventhngs.data.BuildConfig
import com.eventhngs.data.EventhngsPagingRepositoryImpl
import com.eventhngs.data.EventhngsRepositoryImpl
import com.eventhngs.data.SettingsPreferenceRepositoryImpl
import com.eventhngs.data.UserPreference
import com.eventhngs.data.UserPreferenceRepositoryImpl
import com.eventhngs.data.datastore.SettingsPreferenceDataStore
import com.eventhngs.data.datastore.userPreferenceDataStore
import com.eventhngs.data.remote.RemoteDataSource
import com.eventhngs.data.remote.service.EventhngsService
import com.eventhngs.domain.repository.EventhngsPagingRepository
import com.eventhngs.domain.repository.EventhngsRepository
import com.eventhngs.domain.repository.SettingsPreferenceRepository
import com.eventhngs.domain.repository.UserPreferenceRepository
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

    single<DataStore<UserPreference>> {
        get<Context>().userPreferenceDataStore
    }

    single { SettingsPreferenceDataStore(get()) }

    single { RemoteDataSource(get()) }

    single<EventhngsRepository> { EventhngsRepositoryImpl(get()) }

    single<EventhngsPagingRepository> { EventhngsPagingRepositoryImpl(get()) }

    single<UserPreferenceRepository> { UserPreferenceRepositoryImpl(get()) }

    single<SettingsPreferenceRepository> { SettingsPreferenceRepositoryImpl(get()) }

}