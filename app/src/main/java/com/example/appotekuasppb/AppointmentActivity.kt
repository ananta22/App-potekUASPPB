package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_appointment)
        val namadrText = findViewById<TextView>(R.id.namadr)
        val profesidrText = findViewById<TextView>(R.id.profesidr)
        val jamdrText = findViewById<TextView>(R.id.jamdr)
        namadrText.text = AppointmentHandler.namadr
        profesidrText.text = AppointmentHandler.pekerjaandr
        jamdrText.text = AppointmentHandler.jamdr
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.appointButton).setOnClickListener {
            AppointmentHandler.namadr = ""
            AppointmentHandler.pekerjaandr = ""
            AppointmentHandler.jamdr = ""
            Toast.makeText(this, "Appointment berhasil dibuat", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}