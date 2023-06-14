package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.toSecond.setOnClickListener(secondOnclick)
        binding.toThree.setOnClickListener(threeOnClick)
    }

    //toSecond点击事件
    val secondOnclick: (View) -> Unit = {
        //显示指定intent
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    //toThree点击事件
    val threeOnClick: (View) -> Unit = {
        //隐式intent  将自动寻找符合 action为android.intent.action.ALL_APPS , 且category为android.intent.category.APP_BROWSER的activity.   (如intent不设置category, 则默认category类型为android.intent.category.DEFAULT)
        //要跳转的action一定要设置android:exported="true"
        val intent = Intent("test.ThreeActivity")
        ////检测跳转的active是否存在
        val activity = intent.resolveActivity(getPackageManager())
        Log.d("toThreeFunction", (activity == null).toString())
        activity?.shortClassName?.let { it1 -> Log.d("toThreeFunction", it1) }
//        intent.addCategory("android.intent.category.DEFAULT")
        startActivity(intent)
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