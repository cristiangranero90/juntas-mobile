package com.juntas.juntas_app.journey_screen.presentation.components;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.google.android.gms.maps.model.LatLng;
import com.juntas.juntas_app.R;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction;
import java.util.Calendar;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00ba\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0007\u00a8\u0006\u0018"}, d2 = {"MapsOverlay", "", "onContinueClicked", "Lkotlin/Function0;", "passenger", "", "children", "getSite", "Lkotlin/Function1;", "", "setOriginId", "setDestinationId", "predictions", "", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/places/Prediction;", "toPreferenceContext", "", "onMinusChildren", "onPlusChildren", "onMinusPassenger", "onPlusPassenger", "modifier", "Landroidx/compose/ui/Modifier;", "MapsOverlayPreview", "app_debug"})
public final class MapsOverlayKt {
    
    @androidx.compose.runtime.Composable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public static final void MapsOverlay(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onContinueClicked, int passenger, int children, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> getSite, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> setOriginId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> setDestinationId, @org.jetbrains.annotations.NotNull
    java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> predictions, boolean toPreferenceContext, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onMinusChildren, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlusChildren, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onMinusPassenger, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPlusPassenger, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public static final void MapsOverlayPreview() {
    }
}