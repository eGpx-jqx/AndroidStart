package com.example.myapplication.ext

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.longMessage(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}