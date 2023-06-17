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

    /**
     * 配置theme为Dialog， 调用此activity时将展示对话框，不占用全屏, 见@style/Theme.AppCompat.Dialog
     */
}