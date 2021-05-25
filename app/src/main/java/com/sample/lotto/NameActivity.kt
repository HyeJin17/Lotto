package com.sample.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val btnGoResult = findViewById<Button>(R.id.btnGo)
        val btnback = findViewById<Button>(R.id.btnBack)

        btnGoResult.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }
        btnback.setOnClickListener {
            finish()
        }
    }
}