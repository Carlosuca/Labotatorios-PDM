package com.cmpp.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //variables UI
    private lateinit var nHeigthEditText: EditText
    private lateinit var nWeightEditText: EditText
    private lateinit var nButtonSend: Button
    private lateinit var nDisplayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        nDisplayTextView.text = ""
        nButtonSend.setOnClickListener{
            val weight = nWeightEditText.text.toString()
            val height = nHeigthEditText.text.toString()

            val result = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))


            nDisplayTextView.text = getString(R.string.greeting_text,result) //no se porque me agarra el result y creo estar bien


        }


    }

    private fun bind () {
        nHeigthEditText = findViewById(R.id.height_edit_text)
        nWeightEditText = findViewById(R.id.weight_edit_text)
        nButtonSend = findViewById(R.id.action_send)
        nDisplayTextView = findViewById(R.id.view_result_text)

    }

}