package com.assignment.shaadi.models

import com.assignment.shaadi.entities.user.UserEntity
import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("info")
    var info: Info? = null,
    @SerializedName("results")
    var userEntities: MutableList<UserEntity>? = null
) {
    data class Info(
        var page: Int? = null,
        var results: Int? = null,
        var seed: String? = null,
        var version: String? = null
    )
}



