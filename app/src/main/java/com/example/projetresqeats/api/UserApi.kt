package com.example.projetresqeats.api

import com.example.projetresqeats.models.Fournisseur
import com.example.projetresqeats.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap


interface UserApi {

        @POST("user/users")
        fun createUser(@Body user: User): Call<User>

        @POST("beneficiaire/beneficiaires")
        fun createBeneficiaire(@Body fournisseur : Fournisseur) : Call<Fournisseur>

        @PUT("user/users/:id")
        fun updateUser(@Path("id") id : String ): Call<User>

        @DELETE("user/users/:id")
        fun deleteUser(@Path("id") id: String): Call <User>



        @GET("user/login")
        fun login(@QueryMap paramsMap : Map<String, String> ):Call <User>

        @POST("user/search")
        fun search(@Body email: String): Call <User>

        @POST("user/resetpassword")
        fun resetpassword(@Body email: String , @Body password: String) : Call <User>



}