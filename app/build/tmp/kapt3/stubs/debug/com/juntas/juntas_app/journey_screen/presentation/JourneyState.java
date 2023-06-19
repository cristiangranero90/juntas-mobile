package com.juntas.juntas_app.journey_screen.presentation;

import com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction;
import com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u0013H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\u000eH\u00c6\u0003J\t\u00104\u001a\u00020\u000eH\u00c6\u0003J\t\u00105\u001a\u00020\u000eH\u00c6\u0003J\u008d\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u00c6\u0001J\u0013\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020\u0007H\u00d6\u0001J\t\u0010:\u001a\u00020\u000eH\u00d6\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010#R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u00a8\u0006;"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/JourneyState;", "", "isLoading", "", "departureDate", "", "passengers", "", "children", "baggage", "", "error", "Lcom/juntas/juntas_app/journey_screen/presentation/ErrorStatus;", "origin", "", "destination", "originId", "destinationId", "responseRoute", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;", "responsePlace", "", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/places/Prediction;", "(ZJIILjava/util/List;Lcom/juntas/juntas_app/journey_screen/presentation/ErrorStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;Ljava/util/List;)V", "getBaggage", "()Ljava/util/List;", "getChildren", "()I", "getDepartureDate", "()J", "getDestination", "()Ljava/lang/String;", "getDestinationId", "getError", "()Lcom/juntas/juntas_app/journey_screen/presentation/ErrorStatus;", "()Z", "getOrigin", "getOriginId", "getPassengers", "getResponsePlace", "getResponseRoute", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/SpecificRoute;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class JourneyState {
    private final boolean isLoading = false;
    private final long departureDate = 0L;
    private final int passengers = 0;
    private final int children = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Boolean> baggage = null;
    @org.jetbrains.annotations.NotNull
    private final com.juntas.juntas_app.journey_screen.presentation.ErrorStatus error = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String origin = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String destination = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String originId = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String destinationId = null;
    @org.jetbrains.annotations.NotNull
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute responseRoute = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> responsePlace = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.JourneyState copy(boolean isLoading, long departureDate, int passengers, int children, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Boolean> baggage, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.ErrorStatus error, @org.jetbrains.annotations.NotNull
    java.lang.String origin, @org.jetbrains.annotations.NotNull
    java.lang.String destination, @org.jetbrains.annotations.NotNull
    java.lang.String originId, @org.jetbrains.annotations.NotNull
    java.lang.String destinationId, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute responseRoute, @org.jetbrains.annotations.NotNull
    java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> responsePlace) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public JourneyState() {
        super();
    }
    
    public JourneyState(boolean isLoading, long departureDate, int passengers, int children, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Boolean> baggage, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.ErrorStatus error, @org.jetbrains.annotations.NotNull
    java.lang.String origin, @org.jetbrains.annotations.NotNull
    java.lang.String destination, @org.jetbrains.annotations.NotNull
    java.lang.String originId, @org.jetbrains.annotations.NotNull
    java.lang.String destinationId, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute responseRoute, @org.jetbrains.annotations.NotNull
    java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> responsePlace) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getDepartureDate() {
        return 0L;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getPassengers() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getChildren() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Boolean> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Boolean> getBaggage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.ErrorStatus component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.ErrorStatus getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOrigin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDestination() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOriginId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDestinationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.SpecificRoute getResponseRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.juntas.juntas_app.journey_screen.presentation.data.dto.places.Prediction> getResponsePlace() {
        return null;
    }
}