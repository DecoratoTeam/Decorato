package com.example.decorato.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.example.decorato.data.local.datastore.AppLocalPreferences
import com.example.decorato.data.local.datastore.AppLocalPreferencesDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceProviderModule {
    @Provides
    @Singleton
    fun provideDataStore(application: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            application.dataStoreFile("application.preferences_pb")
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceBindsModule {

    @Binds
    @Singleton
    abstract fun bindAppPreferences(
        appPreferencesDataStore: AppLocalPreferencesDataStoreImpl
    ): AppLocalPreferences

}
