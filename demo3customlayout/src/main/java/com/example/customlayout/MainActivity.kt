package com.example.customlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //manifest.xml引入了自定义的头部组件， 这里禁用掉android自带的头组件
        supportActionBar?.hide()
    }
}