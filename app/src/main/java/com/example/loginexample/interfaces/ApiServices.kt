package com.example.loginexample.interfaces

import com.example.loginexample.data.model.web.UserResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServices {

    @GET("api")
    suspend fun getAllUsers() : UserResponse

}

object ApiClient{
    val webservices by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.185.82.90:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}