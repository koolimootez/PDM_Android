package com.example.projetresqeats.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetresqeats.Network.RetrofitUser
import com.example.projetresqeats.R
import com.example.projetresqeats.databinding.ActivityLoginBinding
import com.example.projetresqeats.models.User
import com.example.projetresqeats.utils.SessionManager
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.gamer.utils.MyStatics


class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private var keep: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition { keep }
        Handler(Looper.getMainLooper()).postDelayed({
            keep = false
        }, 1000)
*/
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contextView = binding.root

        binding.tiEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.tiPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatePassword()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })



        binding.btnLogin.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnLogin)
            if (validateEmail() && validatePassword()) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Snackbar.make(
                    binding.root,
                    getString(R.string.msg_error_inputs),
                    Snackbar.LENGTH_SHORT
                )
//                    .setAction("ACTION") {
//                        // Responds to click on the action
//                    }
                    .show()
            }
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }


            val paramsMap: MutableMap<String, String> = HashMap()
            paramsMap["email"] = email
            paramsMap["password"] = password


            val call = RetrofitUser.userApi.login(paramsMap)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val sessionManager= SessionManager(this@LoginActivity)
                        val user = response.body() as User
                        println("user " + user)
                        sessionManager.setUser(user)
                        sessionManager.setLogin(true)
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        // Handle the retrieved post data
                    } else {
                        // Handle error
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    // Handle failure
                }
            })






























/*

            // val user = User ("","","waelbenabdallah@gmail.com" ,"123456","","","")
            val call: Call<JSONObject> = RetrofitUser.userApi.login(email, password)
            call.enqueue(object : Callback<JSONObject> {
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                   println("response  " + response.body())
                    val createdUser = JSONObject(response.body().toString())

                    Toast.makeText(
                        this@LoginActivity,
                        " user logged successfully" + createdUser,
                        Toast.LENGTH_SHORT
                    ).show()
                    sessionManager.setUser(createdUser)
                    sessionManager.setLogin(true)
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                }

                    // Handle the response as needed

                    // Navigate back to the ListDonationsFragment
                    //findNavController().navigateUp()


                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    // Handle error
                    t.printStackTrace()
                    // Show an error message to the user
                    Toast.makeText(
                        this@LoginActivity,
                        "Failed to create User"+ t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
*/
        }


        binding.btnForgotPassword.setOnClickListener {
          //  startActivity(Intent(this, ForgetPasswordActivity::class.java))
        }

        binding.btnFacebookLogin.setOnClickListener {
            Snackbar.make(contextView, getString(R.string.msg_coming_soon), Snackbar.LENGTH_SHORT)
//                .setAction("ACTION") {
//                    // Responds to click on the action
//                }
                .show()
        }

        binding.btnGoogleLogin.setOnClickListener {
            Snackbar.make(contextView, getString(R.string.msg_coming_soon), Snackbar.LENGTH_SHORT)
//                .setAction("ACTION") {
//                    // Responds to click on the action
//                }
                .show()
        }

        val buttonClick = findViewById<Button>(R.id.btnCreateAccount)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SignUpSelonRoleActivity::class.java)
            startActivity(intent)
        }
        val buttonClick1 = findViewById<Button>(R.id.btnForgotPassword)
        binding.btnForgotPassword.setOnClickListener{
            val intent = Intent(this , ResetPasswordActivity::class.java)
            startActivity(intent)
        }

    /*       binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, SignUpSelonRoleActivity::class.java))
        }
*/

    }

    private fun validateEmail(): Boolean {
        binding.tiEmailLayout.isErrorEnabled = false

        if (binding.tiEmail.text.toString().isEmpty()) {
            binding.tiEmailLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiEmail.requestFocus()
            return false
        } else {
            binding.tiEmailLayout.isErrorEnabled = false
        }

        if (Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
            binding.tiEmailLayout.error = getString(R.string.msg_check_your_email)
            binding.tiEmail.requestFocus()
            return false
        } else {
            binding.tiEmailLayout.isErrorEnabled = false
        }

        return true
    }

    private fun validatePassword(): Boolean {
        binding.tiPasswordLayout.isErrorEnabled = false

        if (binding.tiPassword.text.toString().isEmpty()) {
            binding.tiPasswordLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiPassword.requestFocus()
            return false
        } else {
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        if (binding.tiPassword.text.toString().length < 6) {
            binding.tiPasswordLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiPassword.requestFocus()
            return false
        } else {
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        return true
    }

}
