package com.example.loginexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginexample.interfaces.ApiClient
import com.example.loginexample.repositorys.RepoUsers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {
    private val repo = RepoUsers(ApiClient.webservices)
    suspend fun getAllUsers() = flow {
        try {
            emit(repo.getAllUsers())
        } catch (e: Exception) {
            emit(e)
        }
    }.stateIn(viewModelScope)
}