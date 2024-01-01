package com.example.projetresqeats.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.projetresqeats.models.User
import com.google.gson.Gson


class SessionManager(context: Context) {
       private val sharedPreferences: SharedPreferences = context.getSharedPreferences("my preferences" , Context.MODE_PRIVATE)
        private val editor : SharedPreferences.Editor = sharedPreferences.edit()



        private val IS_LOGGED_IN = "isLoggedIn"
        private val USER_ID = "userId"

        fun setLogin(isLoggedIn: Boolean) {
            editor.putBoolean(IS_LOGGED_IN, isLoggedIn)
            editor.apply()
        }

        fun setUser(user: User){
            val gson = Gson()
            val userJson = gson.toJson(user)
            editor.putString("user", userJson)
            editor.apply()

        }

        fun getUser(): User? {
            val gson = Gson()
            val json = sharedPreferences.getString("user", null)
            return gson.fromJson(json, User::class.java)
        }

        fun isLoggedIn(): Boolean {
            return sharedPreferences.getBoolean(IS_LOGGED_IN, false)
        }

        fun setUserId(userId: String) {
            editor.putString(USER_ID, userId)
            editor.apply()
        }

        fun getToken(): String? {
            return sharedPreferences.getString(USER_ID, null)
        }


        fun logout() {
            editor.clear()
            editor.apply()

        }

}