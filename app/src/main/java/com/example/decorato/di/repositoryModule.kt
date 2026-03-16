package com.example.decorato.di


import com.example.decorato.data.repositoryImpl.AppPreferencesRepositoryImpl
import com.example.decorato.data.repositoryImpl.AuthenticationRepositoryImpl
import com.example.decorato.data.repositoryImpl.DesignRepositoryImpl
import com.example.decorato.data.repositoryImpl.RoomTypeRepositoryImpl
import com.example.decorato.data.repositoryImpl.StyleDetailsRepositoryImpl
import com.example.decorato.data.repositoryImpl.StyleRepositoryImpl
import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.repository.DesignRepository
import com.example.decorato.domain.repository.RoomTypeRepository
import com.example.decorato.domain.repository.StyleDetailsRepository
import com.example.decorato.domain.repository.StyleRepository
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
    abstract fun bindDesignRepository(
        designRepositoryImpl: DesignRepositoryImpl
    ): DesignRepository

    @Binds
    @Singleton
    abstract fun provideAuthenticationRepository(
        impl: AuthenticationRepositoryImpl
    ): AuthenticationRepository


    @Binds
    @Singleton
    abstract fun provideAppPreferencesRepository(
        impl: AppPreferencesRepositoryImpl
    ): AppPreferencesRepository

    @Binds
    @Singleton
    abstract fun provideStyleRepository(
        impl: StyleRepositoryImpl
    ): StyleRepository

    @Binds
    @Singleton
    abstract fun provideRoomTypeRepository(
        impl: RoomTypeRepositoryImpl
    ): RoomTypeRepository

    @Binds
    @Singleton
    abstract fun bindStyleDetailsRepository(
        impl: StyleDetailsRepositoryImpl
    ): StyleDetailsRepository


}
