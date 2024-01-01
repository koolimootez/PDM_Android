package com.example.projetresqeats.activities

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.example.projetresqeats.Network.RetrofitUser
import com.example.projetresqeats.databinding.ActivitySignupBinding
import com.example.projetresqeats.models.Fournisseur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddUserActivity : Activity() {

    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Assuming you have a Retrofit instance set up
        binding.btnSignUp.setOnClickListener {
            val username = binding.tiFullName.text.toString()
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()
            val phoneNumber = binding.tiphoneNumber.text.toString()
            val adresse = binding.tiadresse.text.toString()
            val role = binding.tirole.text.toString()
            val mission = binding.timission.text.toString()


            // Check if fields are empty
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()
                || adresse.isEmpty() || role.isEmpty() || mission.isEmpty()
            ) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }


            val newFournisseur = Fournisseur(
                _id = "1555",
                username = username,
                email = email,
                password = password,
                phoneNumber = phoneNumber,
                adresse = adresse,
                role = role,
                mission = mission
            )

            val call: Call<Fournisseur> = RetrofitUser.userApi.createBeneficiaire(newFournisseur)

            call.enqueue(object : Callback<Fournisseur> {
                override fun onResponse(call: Call<Fournisseur>, response: Response<Fournisseur>) {
                    val createdFournisseur = response.body()
                    println("testtest123")
                    Toast.makeText(

                        this@AddUserActivity,

                        " create fournisseur successfully" + createdFournisseur,

                        Toast.LENGTH_SHORT
                    ).show()

                    // Handle the response as needed

                    // Navigate back to the ListDonationsFragment
                    //findNavController().navigateUp()
                }

                override fun onFailure(call: Call<Fournisseur>, t: Throwable) {
                    // Handle error
                    t.printStackTrace()
                    // Show an error message to the user
                        print("testtest123")
                    Toast.makeText(
                        this@AddUserActivity,
                        "Failed to create fournisseur"+ t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        }
    }


// Handle back button click event
        /*backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        */

    }