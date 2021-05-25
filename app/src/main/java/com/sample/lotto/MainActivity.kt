package com.sample.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ConstellCardView = findViewById<CardView>(R.id.ConstellCardView)
        val NameCardView = findViewById<CardView>(R.id.NameCardView)
        val cordRandom = findViewById<CardView>(R.id.cardRandom)


        var intent : Intent

        NameCardView.setOnClickListener {
            intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivity(intent)
        }
        ConstellCardView.setOnClickListener {
            intent = Intent(this@MainActivity, ConstellationActivity::class.java)
            startActivity(intent)
        }
        NameCardView.setOnClickListener {
            intent = Intent(this@MainActivity, NameActivity::class.java)
            startActivity(intent)
        }
    }
}