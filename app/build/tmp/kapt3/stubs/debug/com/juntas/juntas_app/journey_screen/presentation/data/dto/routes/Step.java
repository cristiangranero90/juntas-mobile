package com.juntas.juntas_app.journey_screen.presentation.data.dto.routes;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Step;", "", "distance", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Distance;", "duration", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/TextValueObject;", "polyline", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Polyline;", "startLocation", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/StartLocation;", "endLocation", "Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/EndLocation;", "(Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Distance;Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/TextValueObject;Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Polyline;Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/StartLocation;Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/EndLocation;)V", "getDistance", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Distance;", "getDuration", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/TextValueObject;", "getEndLocation", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/EndLocation;", "getPolyline", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/Polyline;", "getStartLocation", "()Lcom/juntas/juntas_app/journey_screen/presentation/data/dto/routes/StartLocation;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class Step {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "distance")
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Distance distance = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "duration")
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.TextValueObject duration = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "polyline")
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Polyline polyline = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "start_location")
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.StartLocation startLocation = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "end_location")
    private final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.EndLocation endLocation = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Step copy(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Distance distance, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.TextValueObject duration, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Polyline polyline, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.StartLocation startLocation, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.EndLocation endLocation) {
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
    
    public Step(@org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Distance distance, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.TextValueObject duration, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Polyline polyline, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.StartLocation startLocation, @org.jetbrains.annotations.NotNull
    com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.EndLocation endLocation) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Distance component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Distance getDistance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.TextValueObject component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.TextValueObject getDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Polyline component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.Polyline getPolyline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.StartLocation component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.StartLocation getStartLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.EndLocation component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.juntas.juntas_app.journey_screen.presentation.data.dto.routes.EndLocation getEndLocation() {
        return null;
    }
}