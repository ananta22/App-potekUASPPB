package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appotekuasppb.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        findViewById<Button>(R.id.loginButton).setOnClickListener {
            var accessGranted = false
            val usernameLogin = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.usernameFieldInput).text.toString()
            val passwordLogin = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.passwordFieldInput).text.toString()

            var i = 0;

            while(i < AkunHandler.OtenUsernameAkun.size) {
                if(usernameLogin.equals(AkunHandler.OtenUsernameAkun[i]) and passwordLogin.equals(AkunHandler.OtenPasswordAkun[i])) {
                    accessGranted = true
                    AkunHandler.AkunIndex = i
                    break
                } else {
                    accessGranted = false
                }

                i++
            }

            if(accessGranted == true) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.signButton).setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}