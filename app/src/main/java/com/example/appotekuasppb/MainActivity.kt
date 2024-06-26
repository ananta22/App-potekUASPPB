package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val WelcomeText = findViewById<TextView>(R.id.WelcomeText)
        WelcomeText.text = "Welcome, " + AkunHandler.OtenUsernameAkun[AkunHandler.AkunIndex]
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.dokterButton).setOnClickListener {
            val intent = Intent(this, DoctorPage::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.beliObat).setOnClickListener {
            val intent = Intent(this, ObatSelectActivity::class.java)
            startActivity(intent)
            finish()
        }


    }





}