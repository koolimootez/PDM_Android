package com.example.projetresqeats.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.projetresqeats.Network.RetrofitUser
import com.example.projetresqeats.R
import com.example.projetresqeats.databinding.ActivitySignupfoodsupplierBinding
import com.example.projetresqeats.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddFoodSupplierActivity : Activity() {

    private lateinit var binding: ActivitySignupfoodsupplierBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding = ActivitySignupfoodsupplierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<Button>(R.id.btnReturn)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SignUpSelonRoleActivity::class.java)
            startActivity(intent)
        }
        // Assuming you have a Retrofit instance set up
        binding.btnSignUp.setOnClickListener {
            val username = binding.tiFullName.text.toString()
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()
            val phoneNumber = binding.tiphoneNumber.text.toString()
            val adresse = binding.tiadresse.text.toString()
            val role = binding.tirole.text.toString()


            // Check if fields are empty
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()
                || adresse.isEmpty() || role.isEmpty()
            ) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }


            val newUser = User(
                _id  = "1555",
                username = username,
                email = email,
                password = password,
                phoneNumber = phoneNumber,
                adresse = adresse,
                role = role
            )

            val call: Call<User> = RetrofitUser.userApi.createUser(newUser)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val createdUser = response.body()

                    Toast.makeText(
                        this@AddFoodSupplierActivity,
                        " create user successfully" + createdUser,
                        Toast.LENGTH_SHORT
                    ).show()

                    // Handle the response as needed

                    // Navigate back to the ListDonationsFragment
                    //findNavController().navigateUp()
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    // Handle error
                    t.printStackTrace()
                    // Show an error message to the user
                    Toast.makeText(
                        this@AddFoodSupplierActivity,
                        "Failed to create User"+ t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        }
        // Handle back button click event
        /*backButton.setOnClickListener {
            findNavController().navigateUp()
        }*/
    }





}