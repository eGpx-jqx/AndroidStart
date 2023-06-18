package com.example.demoandroidlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.demoandroidlifecycle.databinding.ActivityNormalBinding

class NormalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNormalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}