package com.example.appotekuasppb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ObatSelectActivity : AppCompatActivity() {

    var jumlahobat1 = 0
    var jumlahobat2 = 0
    var jumlahobat3 = 0
    var jumlahobat4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_obat_select)
        val jumlahobat1text = findViewById<TextView>(R.id.jumlahobat1text)
        val jumlahobat2text = findViewById<TextView>(R.id.jumlahobat2text)
        val jumlahobat3text = findViewById<TextView>(R.id.jumlahobat3text)
        val jumlahobat4text = findViewById<TextView>(R.id.jumlahobat4text)
        jumlahobat1text.text = jumlahobat1.toString()
        jumlahobat2text.text = jumlahobat2.toString()
        jumlahobat3text.text = jumlahobat3.toString()
        jumlahobat4text.text = jumlahobat4.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.plusobat1).setOnClickListener {
            jumlahobat1 += 1
            jumlahobat1text.text = jumlahobat1.toString()
        }

        findViewById<Button>(R.id.plusobat2).setOnClickListener {
            jumlahobat2 += 1
            jumlahobat2text.text = jumlahobat2.toString()
        }

        findViewById<Button>(R.id.plusobat3).setOnClickListener {
            jumlahobat3 += 1
            jumlahobat3text.text = jumlahobat3.toString()
        }

        findViewById<Button>(R.id.plusobat4).setOnClickListener {
            jumlahobat4 += 1
            jumlahobat4text.text = jumlahobat4.toString()
        }

        findViewById<Button>(R.id.minobat1).setOnClickListener {
            jumlahobat1 -= 1
            if (jumlahobat1 < 0) {
                jumlahobat1 = 0
                jumlahobat1text.text = jumlahobat1.toString()
            }
            jumlahobat1text.text = jumlahobat1.toString()
        }

        findViewById<Button>(R.id.minobat2).setOnClickListener {
            jumlahobat2 -= 1
            if (jumlahobat2 < 0) {
                jumlahobat2 = 0
                jumlahobat2text.text = jumlahobat2.toString()
            }
            jumlahobat2text.text = jumlahobat2.toString()
        }

        findViewById<Button>(R.id.minobat3).setOnClickListener {
            jumlahobat3 -= 1
            if (jumlahobat3 < 0) {
                jumlahobat3 = 0
                jumlahobat3text.text = jumlahobat3.toString()
            }
            jumlahobat3text.text = jumlahobat3.toString()
        }

        findViewById<Button>(R.id.minobat4).setOnClickListener {
            jumlahobat4 -= 1
            if (jumlahobat4 < 0) {
                jumlahobat4 = 0
                jumlahobat4text.text = jumlahobat4.toString()
            }
            jumlahobat4text.text = jumlahobat4.toString()
        }

        findViewById<Button>(R.id.btnpesan).setOnClickListener {
            BayarHandler.jumlahobat1 = jumlahobat1
            BayarHandler.jumlahobat2 = jumlahobat2
            BayarHandler.jumlahobat3 = jumlahobat3
            BayarHandler.jumlahobat4 = jumlahobat4

            var hargaobat1 = jumlahobat1 * 11000
            var hargaobat2 = jumlahobat2 * 2000
            var hargaobat3 = jumlahobat3 * 10000
            var hargaobat4 = jumlahobat4 * 16000

            BayarHandler.totalharga = hargaobat1 + hargaobat2 + hargaobat3 + hargaobat4

            val intent = Intent(this, BayarActivity::class.java)
            startActivity(intent)
            finish()
        }

        


    }
}