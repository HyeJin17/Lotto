package com.sample.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ResultActivity : AppCompatActivity() {
    //val lottoImageStartId = R.id.imageView1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result") ?: return

        // result.sort()
        //val result_sorted = result?.sortedBy { it } //동작
        //val result_sorted = result?.sortedBy() 동작 오류
        //println("result sorted is $result")

        result?.let {
            updateLottoBallImages(result.sortedBy { it })
        }
    }

        private fun updateLottoBallImages(result_sorted : List<Int>) {
            if(result_sorted.size < 6) return
            val lottoBallImageStartId = R.drawable.ball_01
            /* val lottoBallImageId2 = R.drawable.ball_02
        val lottoBallImageId3 = R.drawable.ball_03*/

            val imageView1 = findViewById<ImageView>(R.id.imageView2)
            val imageView2 = findViewById<ImageView>(R.id.imageView3)
            val imageView3 = findViewById<ImageView>(R.id.imageView4)
            val imageView4 = findViewById<ImageView>(R.id.imageView5)
            val imageView5 = findViewById<ImageView>(R.id.imageView6)
            val imageView6 = findViewById<ImageView>(R.id.imageView7)

            imageView1.setImageResource(lottoBallImageStartId + result_sorted!![0] - 1)
            imageView2.setImageResource(lottoBallImageStartId + result_sorted[1] - 1)
            imageView3.setImageResource(lottoBallImageStartId + result_sorted[2] - 1)
            imageView4.setImageResource(lottoBallImageStartId + result_sorted[3] - 1)
            imageView5.setImageResource(lottoBallImageStartId + result_sorted[4] - 1)
            imageView6.setImageResource(lottoBallImageStartId + result_sorted[5] - 1)
        }
    }
}