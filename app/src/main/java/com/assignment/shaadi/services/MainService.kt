package com.assignment.shaadi.services

import com.assignment.shaadi.constants.Constants
import com.assignment.shaadi.models.MainResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET(Constants.API_URL)
    fun getResults(@Query("results") resultLimit: Int? = 0) : Observable<Response<MainResponse?>?>

}