package com.juntas.juntas_app.journey_screen.presentation;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0018J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006)"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/JourneyViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;", "(Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;)V", "<set-?>", "Lcom/juntas/juntas_app/journey_screen/presentation/JourneyState;", "state", "getState", "()Lcom/juntas/juntas_app/journey_screen/presentation/JourneyState;", "setState", "(Lcom/juntas/juntas_app/journey_screen/presentation/JourneyState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "changeBaggage", "", "position", "", "childrenMinus", "childrenPlus", "dynamicLoading", "getRoute", "getSites", "input", "", "passengerMinus", "passengerPlus", "resetError", "setDeparture", "date", "", "setDestination", "destination", "setDestinationId", "id", "setError", "errorStatus", "Lcom/juntas/juntas_app/journey_screen/presentation/ErrorStatus;", "setOrigin", "origin", "setOriginId", "app_debug"})
public final class JourneyViewModel extends androidx.lifecycle.ViewModel {
    private final com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    
    @javax.inject.Inject
    public JourneyViewModel(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.JourneyState getState() {
        return null;
    }
    
    private final void setState(com.juntas.juntas_app.journey_screen.presentation.JourneyState p0) {
    }
    
    private final void getRoute() {
    }
    
    public final void setDeparture(long date) {
    }
    
    public final void setOriginId(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void setDestinationId(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void changeBaggage(int position) {
    }
    
    public final void getSites(@org.jetbrains.annotations.NotNull
    java.lang.String input) {
    }
    
    private final void dynamicLoading() {
    }
    
    public final void passengerPlus() {
    }
    
    public final void childrenPlus() {
    }
    
    public final void passengerMinus() {
    }
    
    public final void childrenMinus() {
    }
    
    private final void setError(com.juntas.juntas_app.journey_screen.presentation.ErrorStatus errorStatus) {
    }
    
    public final void resetError() {
    }
    
    public final void setOrigin(@org.jetbrains.annotations.NotNull
    java.lang.String origin) {
    }
    
    public final void setDestination(@org.jetbrains.annotations.NotNull
    java.lang.String destination) {
    }
}