package com.example.projetresqeats.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projetresqeats.R
import com.example.projetresqeats.databinding.ResetPasswordBinding
import com.example.projetresqeats.utils.MyStatics
import com.google.android.material.snackbar.Snackbar

class ResetPasswordActivity: AppCompatActivity() {
    private  lateinit var binding: ResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResetPasswordBinding.inflate(this.layoutInflater)


        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)


        binding.tiPassword.addTextChangedListener(object :TextWatcher {
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
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnSubmit)
            if (validatePassword() && validateConfirmPassword()){
                startActivity(Intent(this, LoginActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                })
                finish()
            }else{
                Snackbar.make(contextView, getString(R.string.msg_error_inputs), Snackbar.LENGTH_SHORT).show()
            }
        }

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

    private fun validateConfirmPassword(): Boolean {
        binding.tiConfirmPasswordLayout.isErrorEnabled = false

        if (binding.tiConfirmPassword.text.toString().isEmpty()) {
            binding.tiConfirmPasswordLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiConfirmPassword.requestFocus()
            return false
        }else{
            binding.tiConfirmPasswordLayout.isErrorEnabled = false
        }

        if (binding.tiConfirmPassword.text.toString().length < 6) {
            binding.tiConfirmPasswordLayout.error = getString(R.string.msg_check_your_characters)
            binding.tiConfirmPassword.requestFocus()
            return false
        }else{
            binding.tiConfirmPasswordLayout.isErrorEnabled = false
        }

        if (!binding.tiConfirmPassword.text.toString().equals(binding.tiPassword.text.toString())) {
            binding.tiConfirmPasswordLayout.error = getString(R.string.msg_check_your_confirm_password)
            binding.tiPasswordLayout.error = getString(R.string.msg_check_your_confirm_password)
            binding.tiConfirmPassword.requestFocus()
            return false
        }else{
            binding.tiConfirmPasswordLayout.isErrorEnabled = false
            binding.tiPasswordLayout.isErrorEnabled = false
        }

        return true
    }
}