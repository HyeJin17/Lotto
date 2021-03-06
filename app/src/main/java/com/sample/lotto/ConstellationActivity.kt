package com.sample.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

fun getLottoNumbersFromHash(str: String): MutableList<Int> {
    val list = mutableListOf<Int>()

    for (number in 1..45) {
        list.add(number)
    }

    val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date()) + str

    list.shuffle(Random(targetString.hashCode().toLong()))
    return list.subList(0, 6)
}

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoResult = findViewById<Button>(R.id.btnGoResult)
        val datePicker = findViewById<DatePicker>(R.id.dataPicker)
        val txtConstell = findViewById<TextView>(R.id.txtHoroscope)
        val calendar = Calendar.getInstance()

        txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            override fun onSelectedDayChange(p0:CalendarView, p1:Int, p2:Int, p3:Int) {
                TODO("Not yet implemented")
            }

            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                TODO("Not yet implemented")
                txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
            }
        }
        )
        btnGoResult.setOnClickListener {
            val itent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(txtConstell.text.toString())))
            intent.putExtra("constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }

        //        val calendar = Calendar.getInstance()


/*        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
            object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener {
                override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                    textHoroscope.text = makeHoroscopeString(datePicker.month, datePicker.dayOfMonth)
                }
                override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                    TODO("Not yet implemented")
                }
            }
                )*/


        //textHoroscope.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
    }

    private fun makeConstellationString(month: Int, dayOfMonth: Int): String {
//        val target = "${month}${String.format("%02d",dayOfMonth)}".toInt()
        val target = "${month + 1}${String.format("%02d",dayOfMonth)}".toInt()

        when (target){
            in 101..119 -> return "????????????"
            in 120..218 -> return "????????????"
            in 219..320 -> return "???????????????"
            in 321..419 -> return "?????????"
            in 420..520 -> return "????????????"
            in 521..621 -> return "???????????????"
            in 622..722 -> return "?????????"
            in 723..822 -> return "????????????"
            in 823..923 -> return "????????????"
            in 924..1022 -> return "????????????"
            in 1023..1122 -> return "????????????"
            in 1123..1224 -> return "????????????"
            in 1225..1231 -> return "????????????"
            else -> return "???????????????"
        }
    }
}