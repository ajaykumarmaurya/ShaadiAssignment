package com.assignment.shaadi.entities.user

import com.assignment.shaadi.constants.Status

data class UserStatus(var voted: Boolean = false, var status: Status? = null)