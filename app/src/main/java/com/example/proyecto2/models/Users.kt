package com.example.proyecto2.models
import com.example.proyecto2.models.database.entities.UserEntity


class Users {
    var users = ArrayList<UserEntity>()
    constructor(users: ArrayList<UserEntity>){
        this.users = users
    }

}