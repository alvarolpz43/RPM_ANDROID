package com.example.loginexample.repositorys

import com.example.loginexample.data.model.web.UserResponse
import com.example.loginexample.interfaces.ApiServices

class RepoUsers(val apiServices: ApiServices) {
    suspend fun getAllUsers() : UserResponse = apiServices.getAllUsers()
}