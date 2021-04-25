package com.assignment.shaadi.ui.main.di

import android.content.Context
import com.assignment.shaadi.interactors.UserEntityInteractor
import com.assignment.shaadi.services.MainService
import com.assignment.shaadi.ui.main.MainActivity
import com.assignment.shaadi.ui.main.core.MainActivityModel
import com.assignment.shaadi.ui.main.core.MainActivityPresenter
import com.assignment.shaadi.utils.NetworkUtil
import com.assignment.shaadi.utils.SweetDialogUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    @ActivityScoped
    fun provideModel(
        userEntityInteractor: UserEntityInteractor,
        mainService: MainService
    ): MainActivityModel {
        return MainActivityModel(userEntityInteractor, mainService)
    }

    @Provides
    @ActivityScoped
    fun provideSweetAlertUtil(@ActivityContext context: Context): SweetDialogUtil {
        return SweetDialogUtil(context)
    }

    @Provides
    @ActivityScoped
    fun providePresenter(
        view: MainActivity,
        model: MainActivityModel,
        networkUtil: NetworkUtil,
        sweetDialogUtil: SweetDialogUtil
    ): MainActivityPresenter {
        return MainActivityPresenter(view, model, networkUtil, sweetDialogUtil)
    }

    @Provides
    @ActivityScoped
    fun provideActivity(@ActivityContext context: Context): MainActivity {
        return context as MainActivity
    }

}
