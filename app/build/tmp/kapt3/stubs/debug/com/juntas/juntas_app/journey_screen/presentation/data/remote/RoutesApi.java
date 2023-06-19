package com.juntas.juntas_app.journey_screen.presentation.data.remote;

import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.placesResponseDto;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute;
import retrofit2.http.GET;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J9\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJC\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/data/remote/RoutesApi;", "", "getRoute", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;", "origin", "", "destination", "region", "api_key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSites", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/places/placesResponseDto;", "toSearch", "lang", "radius", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface RoutesApi {
    @org.jetbrains.annotations.NotNull
    public static final com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://maps.googleapis.com/maps/api/";
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "directions/json?")
    public abstract java.lang.Object getRoute(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "origin")
    java.lang.String origin, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "destination")
    java.lang.String destination, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "region")
    java.lang.String region, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "place/autocomplete/json?")
    public abstract java.lang.Object getSites(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "input")
    java.lang.String toSearch, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "language")
    java.lang.String lang, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "radius")
    java.lang.String radius, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "key")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.juntas.juntas_app.journey_screen.presentation.data.dto.places.placesResponseDto> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/data/remote/RoutesApi$Companion;", "", "()V", "BASE_URL", "", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String BASE_URL = "https://maps.googleapis.com/maps/api/";
        
        private Companion() {
            super();
        }
    }
}