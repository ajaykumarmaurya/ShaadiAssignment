package com.assignment.shaadi.ui.main

import com.assignment.shaadi.entities.user.UserEntity
import com.assignment.shaadi.global.GlobalPresenter
import com.assignment.shaadi.global.GlobalView
import com.assignment.shaadi.models.MainResponse
import io.reactivex.Observable
import retrofit2.Response

interface MainActivityContractMVP {

    interface View : GlobalView {
        fun loadUserDataInAdapter(users: MutableList<UserEntity>)
        fun updateUserInAdapter(user: UserEntity, adapterPosition: Int)
        fun toggleProgressBar(status :Boolean)
    }

    interface Presenter : GlobalPresenter {
        fun loadUserData()
    }

    interface Model {
        fun getUserDataFromAPI(): Observable<Response<MainResponse?>?>?
        fun getUserDataFromDB(): MutableList<UserEntity>
        fun updateUserInDB(userEntity: UserEntity, onSuccess: () -> Unit)
        fun saveAllUserInDB(users: MutableList<UserEntity>)
    }


}