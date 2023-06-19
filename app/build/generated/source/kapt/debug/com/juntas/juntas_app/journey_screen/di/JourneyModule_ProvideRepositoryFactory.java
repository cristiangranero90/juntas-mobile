// Generated by Dagger (https://dagger.dev).
package com.juntas.juntas_app.journey_screen.di;

import com.juntas.juntas_app.journey_screen.presentation.data.remote.RoutesApi;
import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class JourneyModule_ProvideRepositoryFactory implements Factory<RoutesRepository> {
  private final Provider<RoutesApi> apiProvider;

  public JourneyModule_ProvideRepositoryFactory(Provider<RoutesApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RoutesRepository get() {
    return provideRepository(apiProvider.get());
  }

  public static JourneyModule_ProvideRepositoryFactory create(Provider<RoutesApi> apiProvider) {
    return new JourneyModule_ProvideRepositoryFactory(apiProvider);
  }

  public static RoutesRepository provideRepository(RoutesApi api) {
    return Preconditions.checkNotNullFromProvides(JourneyModule.INSTANCE.provideRepository(api));
  }
}
