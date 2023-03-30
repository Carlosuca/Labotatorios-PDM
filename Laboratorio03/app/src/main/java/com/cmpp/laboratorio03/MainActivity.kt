package com.cmpp.laboratorio03

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    private lateinit var nImageFiveCents: ImageView
    private lateinit var ImageTenCents: ImageView
    private lateinit var QuarterImage: ImageView
    private lateinit var DollarImage: ImageView
    private lateinit var CountDinnerTextView: TextView

    //data element
    private var fiveCent = 0.050
    private var tenCent = 0.10
    private var quarterDollar = 0.25
    private var Dollar = 1.00
    private var result = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addMoney()
    }

    private fun addMoney() {
        CountDinnerTextView.text = "0"

        nImageFiveCents.setOnClickListener{
            result += fiveCent
            CountDinnerTextView.text = String.format("%.2f", result)

        }
        ImageTenCents.setOnClickListener{
            result += tenCent
            CountDinnerTextView.text = String.format("%.2f", result)
        }
        QuarterImage.setOnClickListener{
            result += quarterDollar
            CountDinnerTextView.text = String.format("%.2f", result)
        }
        DollarImage.setOnClickListener{
            result += Dollar
            CountDinnerTextView.text = String.format("%.2f", result)
        }
    }

    private fun bind() {
        nImageFiveCents = findViewById(R.id.five_cent_image_view)
        ImageTenCents = findViewById(R.id.ten_cents_image_view)
        QuarterImage = findViewById(R.id.quarter_dollar_image_view)
        DollarImage = findViewById(R.id.dollar_image_view)
        CountDinnerTextView = findViewById(R.id.count_dinner_text_view)
    }

}