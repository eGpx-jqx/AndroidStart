package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityThreeBinding

class ThreeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}