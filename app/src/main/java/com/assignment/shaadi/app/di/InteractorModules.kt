package com.assignment.shaadi.app.di

import com.assignment.shaadi.interactors.UserEntityInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object InteractorModules  {

    @Provides
    @Singleton
    fun provideUserInterractor(): UserEntityInteractor {
        return UserEntityInteractor()
    }

}