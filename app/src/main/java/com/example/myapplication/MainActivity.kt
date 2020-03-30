package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Register(view:View) {
        startActivity(Intent(applicationContext, Register::class.java))
    }

    fun Login(view:View) {
        startActivity(Intent(applicationContext, LogIn::class.java))
    }
}
