package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appotekuasppb.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        findViewById<Button>(R.id.signUpButton)
            .setOnClickListener {
            val signUpUsername = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.usernameFieldInput).text.toString()
            val signUpPassword = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.passwordFieldInput).text.toString()
            val signUpConfPassword = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.passwordConfFieldInput).text.toString()

            if (signUpPassword.equals(signUpConfPassword)) {
                AkunHandler.OtenUsernameAkun.add(signUpUsername)
                AkunHandler.OtenPasswordAkun.add(signUpPassword)
                Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Sign up failed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.backButton)
            .setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}