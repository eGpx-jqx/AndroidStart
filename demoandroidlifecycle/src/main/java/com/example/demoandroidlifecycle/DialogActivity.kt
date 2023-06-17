package com.example.demoandroidlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoandroidlifecycle.databinding.ActivityDialogBinding

class DialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}