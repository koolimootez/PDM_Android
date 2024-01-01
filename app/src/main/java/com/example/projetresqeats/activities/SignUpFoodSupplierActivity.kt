package com.example.projetresqeats.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projetresqeats.R
import com.example.projetresqeats.databinding.ActivitySignupfoodsupplierBinding
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.utils.MyStatics

class SignUpFoodSupplierActivity : AppCompatActivity(){
    private lateinit var binding: ActivitySignupfoodsupplierBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupfoodsupplierBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)

        binding.tiFullName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateFullName()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

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

        binding.tiphoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatephoneNumber()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.btnSignUp.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnSignUp)
            if (validateFullName() && validateEmail() && validatePassword() && validatephoneNumber() && validateadresse() && validaterole()){
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Snackbar.make(contextView, getString(R.string.msg_error_inputs), Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnTermsAndPolicy.setOnClickListener {
            Snackbar.make(contextView, getString(R.string.msg_coming_soon), Snackbar.LENGTH_SHORT).show()
        }

       /* binding.btnReturn.setOnClickListener {
            finish()
        }*/
    }



    private fun validaterole(): Boolean {
        binding.tiroleLayout.isErrorEnabled = false
        if (binding.tirole.text.toString().isEmpty()) {
            binding.tiroleLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tirole.requestFocus()
            return false
        }else{
            binding.tiroleLayout.isErrorEnabled = false
        }
        if (binding.tirole.text.toString().length < 6) {
            binding.tiroleLayout.error = getString(R.string.msg_check_your_characters)
            binding.tirole.requestFocus()
            return false
        }else{
            binding.tiroleLayout.isErrorEnabled = false
        }
        return  true
    }

    private fun validateadresse(): Boolean {
        binding.tiadresseLayout.isErrorEnabled = false
        if (binding.tiadresse.text.toString().isEmpty()) {
            binding.tiadresseLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiadresse.requestFocus()
            return false
        }else{
            binding.tiadresseLayout.isErrorEnabled = false
        }
        if (binding.tiadresse.text.toString().length < 6) {
            binding.tiadresseLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiadresse.requestFocus()
            return false
        }else{
            binding.tiadresseLayout.isErrorEnabled = false
        }
        return  true
    }

    private fun validatephoneNumber(): Boolean {
        binding.tiphoneNumberLayout.isErrorEnabled = false
        if (binding.tiphoneNumber.text.toString().isEmpty()) {
            binding.tiphoneNumberLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiphoneNumber.requestFocus()
            return false
        }else{
            binding.tiphoneNumberLayout.isErrorEnabled = false
        }
        if (binding.tiphoneNumber.text.toString().length < 6) {
            binding.tiphoneNumberLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiphoneNumber.requestFocus()
            return false
        }else{
            binding.tiphoneNumberLayout.isErrorEnabled = false
        }
        return  true
    }


    private fun validateFullName(): Boolean {
        binding.tiFullNameLayout.isErrorEnabled = false

        if (binding.tiFullName.text.toString().isEmpty()) {
            binding.tiFullNameLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiFullName.requestFocus()
            return false
        }else{
            binding.tiFullNameLayout.isErrorEnabled = false
        }

        if (binding.tiFullName.text.toString().length < 6) {
            binding.tiFullNameLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiFullName.requestFocus()
            return false
        }else{
            binding.tiFullNameLayout.isErrorEnabled = false
        }

        return true
    }

    private fun validateEmail(): Boolean {
        binding.tiEmailLayout.isErrorEnabled = false

        if (binding.tiEmail.text.toString().isEmpty()) {
            binding.tiEmailLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiEmail.requestFocus()
            return false
        }else{
            binding.tiEmailLayout.isErrorEnabled = false
        }

        if (Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
            binding.tiEmailLayout.error = getString(R.string.msg_check_your_email)
            binding.tiEmail.requestFocus()
            return false
        }else{
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
        }else{
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        if (binding.tiPassword.text.toString().length < 6) {
            binding.tiPasswordLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiPassword.requestFocus()
            return false
        }else{
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        return true
    }


}