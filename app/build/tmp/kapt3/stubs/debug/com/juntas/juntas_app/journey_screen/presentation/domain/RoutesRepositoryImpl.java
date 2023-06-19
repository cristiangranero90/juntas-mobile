package com.juntas.juntas_app.journey_screen.presentation.domain;

import com.juntas.juntas_app.BuildConfig;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.placesResponseDto;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute;
import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ2\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepositoryImpl;", "Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;", "api", "Lcom/juntas/juntas_app/journey_screen/presentation/data/remote/RoutesApi;", "(Lcom/juntas/juntas_app/journey_screen/presentation/data/remote/RoutesApi;)V", "lang", "", "getPlaces", "Lkotlin/Result;", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/places/placesResponseDto;", "toSearch", "getPlaces-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSpecificRoute", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;", "origin", "destination", "getSpecificRoute-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RoutesRepositoryImpl implements com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository {
    private final com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi api = null;
    private final java.lang.String lang = null;
    
    public RoutesRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi api) {
        super();
    }
}