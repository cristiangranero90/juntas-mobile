package com.juntas.juntas_app.journey_screen.di;

import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi;
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository;
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/di/JourneyModule;", "", "()V", "provideApi", "Lcom/juntas/juntas_app/journey_screen/presentation/data/remote/RoutesApi;", "provideRepository", "Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;", "api", "app_debug"})
@dagger.Module
public final class JourneyModule {
    @org.jetbrains.annotations.NotNull
    public static final com.juntas.juntas_app.journey_screen.di.JourneyModule INSTANCE = null;
    
    private JourneyModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi provideApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository provideRepository(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi api) {
        return null;
    }
}