package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DoctorPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.appointdr1btn).setOnClickListener {
            AppointmentHandler.namadr = findViewById<TextView>(R.id.namadr1).text.toString()
            AppointmentHandler.pekerjaandr = findViewById<TextView>(R.id.profesidr1).text.toString()
            AppointmentHandler.jamdr = findViewById<TextView>(R.id.jamdr1).text.toString()

            val intent = Intent(this, AppointmentActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.appointdr2btn).setOnClickListener {
            AppointmentHandler.namadr = findViewById<TextView>(R.id.namadr2).text.toString()
            AppointmentHandler.pekerjaandr = findViewById<TextView>(R.id.profesidr2).text.toString()
            AppointmentHandler.jamdr = findViewById<TextView>(R.id.jamdr2).text.toString()

            val intent = Intent(this, AppointmentActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<Button>(R.id.backBtn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}