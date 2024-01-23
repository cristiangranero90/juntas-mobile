package com.juntas.juntas_app.core.di

import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juntas.juntas_app.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideAuthInstance() = Firebase.auth

    @Provides
    @Singleton
    fun provideGoogleSignIn() = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(BuildConfig.SERVER_CLIENT)
                .setFilterByAuthorizedAccounts(false)
                .build())
        .build()

    @Provides
    @Singleton
    fun provideGoogleOptions() = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(BuildConfig.SERVER_CLIENT)
        .requestEmail()
        .build()

    @Provides
    @Singleton
    fun provideRemoteDatabase() = Firebase
    //TODO: Add Firestore
}