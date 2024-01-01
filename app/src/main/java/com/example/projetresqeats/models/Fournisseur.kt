package com.example.projetresqeats.models

data class Fournisseur(
    val _id:String,
    val username: String,
    val email:String,
    val password:String,
    val phoneNumber:String,
    val adresse:String,
    val role:String,
    val mission:String
)
