package com.cmpp.laboratorio05.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.cmpp.laboratorio05.R
import com.cmpp.laboratorio05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

//binding = ActivityMainBinding.inflate(inflater, container, false)