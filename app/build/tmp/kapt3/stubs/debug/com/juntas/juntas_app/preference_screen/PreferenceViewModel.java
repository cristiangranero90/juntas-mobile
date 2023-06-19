package com.juntas.juntas_app.preference_screen;

import androidx.lifecycle.ViewModel;
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository;
import com.juntas.juntas_app.preference_screen.presentation.PreferenceState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/juntas/juntas_app/preference_screen/PreferenceViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;", "(Lcom/juntas/juntas_app/journey_screen/presentation/domain/RoutesRepository;)V", "<set-?>", "Lcom/juntas/juntas_app/preference_screen/presentation/PreferenceState;", "state", "getState", "()Lcom/juntas/juntas_app/preference_screen/presentation/PreferenceState;", "setState", "(Lcom/juntas/juntas_app/preference_screen/presentation/PreferenceState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "allergyText", "", "text", "", "chairText", "changeAllergy", "changeChair", "changeChildren", "changeMedication", "changePet", "changeSmoker", "medicationText", "otherText", "app_debug"})
public final class PreferenceViewModel extends androidx.lifecycle.ViewModel {
    private final com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    
    @javax.inject.Inject
    public PreferenceViewModel(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.preference_screen.presentation.PreferenceState getState() {
        return null;
    }
    
    private final void setState(com.juntas.juntas_app.preference_screen.presentation.PreferenceState p0) {
    }
    
    public final void changeSmoker() {
    }
    
    public final void changePet() {
    }
    
    public final void changeChildren() {
    }
    
    public final void changeAllergy() {
    }
    
    public final void changeChair() {
    }
    
    public final void changeMedication() {
    }
    
    public final void allergyText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void chairText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void medicationText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void otherText(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}