package com.example.projetresqeats.activities

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.example.projetresqeats.Network.RetrofitUser
import com.example.projetresqeats.databinding.ActivityFragmentprofileBinding
import com.example.projetresqeats.models.User
import com.example.projetresqeats.utils.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : Activity() {
    private lateinit var binding: ActivityFragmentprofileBinding
    private  lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnSedeconnecter.setOnClickListener() {
            //    logout()
        }
        binding.btnEditProfile.setOnClickListener {
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
                _id = "1555",
                username = username,
                email = email,
                password = password,
                phoneNumber = phoneNumber,
                adresse = adresse,
                role = role
            )
/*
            val call: Call<User> = RetrofitUser.userApi.updateUser(newUser)
            println("testtest123")
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val createdUser = response.body()

                    Toast.makeText(
                        this@EditProfileActivity,
                        "  User updated successfully" + createdUser,
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
                        this@EditProfileActivity,
                        "Failed to update User"+ t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
*/
        }
        binding.btnDeleteProfile.setOnClickListener {
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


            val oldUSer = User(
                _id = "1555",
                username = username,
                email = email,
                password = password,
                phoneNumber = phoneNumber,
                adresse = adresse,
                role = role
            )

            val call: Call<User> = RetrofitUser.userApi.deleteUser(id= String())

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val createdUser = response.body()

                    Toast.makeText(
                        this@EditProfileActivity,
                        " user deleted successfully" + createdUser,
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
                        this@EditProfileActivity,
                        "Failed to delete User"+ t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        }

        /* fun logout() {
            SessionManager.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

         */

    }
}