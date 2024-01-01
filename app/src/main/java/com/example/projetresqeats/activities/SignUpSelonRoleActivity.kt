package com.example.projetresqeats.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projetresqeats.R
import com.example.projetresqeats.databinding.ActivitySignupselonroleBinding

class SignUpSelonRoleActivity : AppCompatActivity() {

     private lateinit var binding: ActivitySignupselonroleBinding
   //  private  var keep : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

       binding = ActivitySignupselonroleBinding.inflate(layoutInflater)
       setContentView(binding.root)


      /*binding.btnReturn.setOnClickListener(){
           onBackPressedDispatcher.onBackPressed()
       }*/

     val buttonClick2 = findViewById<Button>(R.id.btnReturn)
       buttonClick2.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
       }

       val buttonClick = findViewById<Button>(R.id.txtAsaRecepient)
       binding.txtAsaRecepient.setOnClickListener(){
           val intent = Intent(this ,AddFoodSupplierActivity::class.java)
           startActivity(intent)


       }
       val buttonClick1 = findViewById<Button>(R.id.txtAsaFoodSupplier)
       binding.txtAsaFoodSupplier.setOnClickListener(){
           val intent = Intent(this ,SignUpActivity::class.java)
           startActivity(intent)
       }
       /*binding.btnReturn.setOnClickListener {
           finish()
       }*/
   }
}