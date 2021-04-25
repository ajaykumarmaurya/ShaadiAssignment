package com.assignment.shaadi.adapters

import com.assignment.shaadi.entities.user.UserEntity

interface UserAdapterListener {
    fun acceptUser(user: UserEntity, adapterPosition: Int)
    fun declineUser(user: UserEntity, adapterPosition: Int)
}