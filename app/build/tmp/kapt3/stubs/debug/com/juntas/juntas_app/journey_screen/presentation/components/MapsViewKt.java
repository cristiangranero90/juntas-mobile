package com.juntas.juntas_app.journey_screen.presentation.components;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.tooling.preview.Preview;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.compose.MapProperties;
import com.google.maps.android.compose.MapType;
import com.google.maps.android.compose.MarkerState;
import com.juntas.juntas_app.R;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00c2\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0007\u00a8\u0006\u001a"}, d2 = {"MapsView", "", "onContinueClicked", "Lkotlin/Function0;", "specificRoute", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;", "passenger", "", "children", "getSite", "Lkotlin/Function1;", "", "setOriginId", "setDestinationId", "predictions", "", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/places/Prediction;", "toPreferenceContext", "", "onMinusChildren", "onPlusChildren", "onMinusPassenger", "onPlusPassenger", "modifier", "Landroidx/compose/ui/Modifier;", "MapsViewPreview", "app_debug"})
public final class MapsViewKt {
    
    @androidx.compose.runtime.Composable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    public static final void MapsView(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onContinueClicked, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute specificRoute, int passenger, int children, @org.jetbrains.annotations.NotNull
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
    public static final void MapsViewPreview() {
    }
}