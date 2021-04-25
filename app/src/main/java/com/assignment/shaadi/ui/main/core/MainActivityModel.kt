package com.assignment.shaadi.ui.main.core

import com.assignment.shaadi.constants.Constants
import com.assignment.shaadi.entities.user.UserEntity
import com.assignment.shaadi.interactors.UserEntityInteractorI
import com.assignment.shaadi.models.MainResponse
import com.assignment.shaadi.services.MainService
import com.assignment.shaadi.ui.main.MainActivityContractMVP
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class MainActivityModel @Inject constructor(
    private val userEntityInteractor: UserEntityInteractorI,
    private val mainService: MainService
) : MainActivityContractMVP.Model {

    override fun getUserDataFromAPI(): Observable<Response<MainResponse?>?>? {
        return mainService.getResults(Constants.RESULT_LIMIT)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUserDataFromDB(): MutableList<UserEntity> {
        return userEntityInteractor.getAllUsers()
    }

    override fun updateUserInDB(userEntity: UserEntity, onSuccess: () -> Unit) {
        return userEntityInteractor.updateUser(userEntity) {
            onSuccess.invoke()
        }
    }

    override fun saveAllUserInDB(users: MutableList<UserEntity>) {
        return userEntityInteractor.saveAllUsers(users)
    }


}