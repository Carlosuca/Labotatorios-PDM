package com.cmpp.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nEditTextName: TextInputEditText
    private lateinit var nEditTextEmail: TextInputEditText
    private lateinit var nEditTextPhone: TextInputEditText
    private lateinit var nButtonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        SendData()
    }

    fun bind() {
        nEditTextName = findViewById(R.id.input_text_name)
        nEditTextEmail = findViewById(R.id.input_text_email)
        nEditTextPhone = findViewById(R.id.input_text_phone)
        nButtonSend = findViewById(R.id.result_send)
    }

    private fun SendData() {
        nButtonSend.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("name", nEditTextName.text.toString())
            intent.putExtra("email", nEditTextEmail.text.toString())
            intent.putExtra("phone", nEditTextPhone.text.toString())
            startActivity(intent)
        }
    }

}