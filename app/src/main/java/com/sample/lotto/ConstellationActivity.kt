package com.sample.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoResult = findViewById<Button>(R.id.btnGoResult)

       //여기부터
        btnGoResult.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java)) //Intent Branch 부분
        }
    }
}