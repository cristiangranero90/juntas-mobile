package com.juntas.juntas_app.journey_screen.di

import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object JourneyModule {

    @Provides
    @Singleton
    fun provideApi() : RoutesApi {
        return Retrofit.Builder()
            .baseUrl(RoutesApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient
                .Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: RoutesApi) : RoutesRepository {
        return RoutesRepositoryImpl(api)
    }
}