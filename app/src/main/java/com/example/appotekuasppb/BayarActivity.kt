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

class BayarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bayar)
        val hargatotal = BayarHandler.totalharga.toString()
        val obat1text = findViewById<TextView>(R.id.obat1jumlah)
        val obat2text = findViewById<TextView>(R.id.obat2jumlah)
        val obat3text = findViewById<TextView>(R.id.obat3jumlah)
        val obat4text = findViewById<TextView>(R.id.obat4jumlah)
        val totalhargatext = findViewById<TextView>(R.id.totalhargatext)
        obat1text.text = BayarHandler.jumlahobat1.toString()
        obat2text.text = BayarHandler.jumlahobat2.toString()
        obat3text.text = BayarHandler.jumlahobat3.toString()
        obat4text.text = BayarHandler.jumlahobat4.toString()
        totalhargatext.text = "Rp. " + hargatotal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.KonfirmasiPembayaranBtn).setOnClickListener{
                Toast.makeText(this, "Pembayaran ", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}