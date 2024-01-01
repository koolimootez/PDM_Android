package com.example.projetresqeats.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetresqeats.R
import com.example.projetresqeats.api.UserApi
import com.example.projetresqeats.databinding.ResetPasswordBinding
import com.example.projetresqeats.models.Password
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.utils.MyStatics

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ResetPasswordBinding
    private lateinit var UserApi: UserApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResetPasswordBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)
        binding.btnSubmit.setOnClickListener() {
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() ) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val newPassword = Password(
                email = email,
                password = password,

            )

  /*       val call: Call<User> = RetrofitUser.userApi.resetpassword(newPassword)
            call.enqueue(object : Callback<Password> {
                override fun onResponse(call: Call<Password>, response: Response<Password>) {
                    val createdUser = response.body()
                    Toast.makeText(
                        this@ResetPasswordActivity,
                        " reset password has been successfully" + createdUser,
                        Toast.LENGTH_SHORT
                    ).show()
                    // Handle the response as needed
                    // Navigate back to the ListDonationsFragment
                    //findNavController().navigateUp()
                }
                override fun onFailure(call: Call<Password>, t: Throwable) {
                    // Handle error
                    t.printStackTrace()
                    // Show an error message to the user
                    Toast.makeText(
                        this@ResetPasswordActivity,
                        "Failed to reset password" + t.localizedMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })*/



        }
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


        binding.btnReturn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnSubmit.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnSubmit)
            if (validatePassword() && validateEmail()) {
               // ContextCompat.startActivity(Intent(this, LoginActivity::class.java).apply {
                    //addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

               // })

                finish()
            }
            else {
                Snackbar.make(contextView, getString(R.string.msg_error_inputs), Snackbar.LENGTH_SHORT)
                    .show()
            }
        }


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

        if (binding.tiEmail.text.toString().length < 6) {
            binding.tiEmailLayout.error = getString(R.string.msg_check_your_characters)
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

        if (!binding.tiPassword.text.toString().equals(binding.tiPassword.text.toString())) {
            binding.tiPasswordLayout.error = getString(R.string.msg_check_your_confirm_Password)
            binding.tiPasswordLayout.error = getString(R.string.msg_check_your_confirm_Password)
            binding.tiPassword.requestFocus()
            return false
        } else {
            binding.tiPasswordLayout.isErrorEnabled = false
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        return true
    }
}






