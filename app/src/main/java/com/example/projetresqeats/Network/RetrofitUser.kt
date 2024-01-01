package com.example.projetresqeats.Network

import com.example.projetresqeats.api.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUser {

    private const val BASE_URL = "http://192.168.1.113:7019/" // Replace with your actual backend URL

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApi: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }
}