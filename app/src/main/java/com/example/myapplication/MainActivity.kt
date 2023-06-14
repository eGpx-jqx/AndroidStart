package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ext.longMessage


class MainActivity : AppCompatActivity() {

    //见: https://juejin.cn/post/6921677731088646158
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val function: (View) -> Unit = {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        binding.toSecond.setOnClickListener(function)
    }


    //meun相关
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> longMessage("you click add_item")
            R.id.remove_item -> longMessage("you click remove_item")
        }
        return true
    }
}