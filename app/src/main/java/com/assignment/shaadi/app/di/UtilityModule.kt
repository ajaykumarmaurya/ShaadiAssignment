package com.assignment.shaadi.app.di

import android.content.Context
import com.assignment.shaadi.utils.NetworkUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UtilityModule {

    @Provides
    @Singleton
    fun provideNetworkUtil(@ApplicationContext context: Context): NetworkUtil {
        return NetworkUtil(context)
    }

}