package com.example.decorato.di


import com.example.decorato.data.repositoryImpl.AppPreferencesRepositoryImpl
import com.example.decorato.data.repositoryImpl.AuthenticationRepositoryImpl
import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.repository.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindAuthenticationRepository(
        impl: AuthenticationRepositoryImpl
    ): AuthenticationRepository


    @Binds
    @Singleton
    abstract fun bindAppPreferencesRepository(
        impl: AppPreferencesRepositoryImpl
    ): AppPreferencesRepository

}
