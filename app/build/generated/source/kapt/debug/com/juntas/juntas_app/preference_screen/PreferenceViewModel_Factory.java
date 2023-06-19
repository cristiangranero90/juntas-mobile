// Generated by Dagger (https://dagger.dev).
package com.juntas.juntas_app.preference_screen;

import com.juntas.juntas_app.journey_screen.presentation.domain.RoutesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PreferenceViewModel_Factory implements Factory<PreferenceViewModel> {
  private final Provider<RoutesRepository> repositoryProvider;

  public PreferenceViewModel_Factory(Provider<RoutesRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PreferenceViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PreferenceViewModel_Factory create(Provider<RoutesRepository> repositoryProvider) {
    return new PreferenceViewModel_Factory(repositoryProvider);
  }

  public static PreferenceViewModel newInstance(RoutesRepository repository) {
    return new PreferenceViewModel(repository);
  }
}
