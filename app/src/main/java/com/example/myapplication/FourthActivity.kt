package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import com.example.myapplication.databinding.ActivityFourthBinding
import com.example.myapplication.ext.longMessage
import kotlin.math.log

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //获取上个activity传输的数据
        val stringExtra = intent.getStringExtra("ext1")
        Log.d("intent", "stringExtra: $stringExtra")


        //配置当点击返回按钮导致活动不在栈顶 返回数据
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                longMessage("you pressed back")

                //此方法用于传输数据给调用方activity
                setResult(RESULT_OK, getReturnIntent())

                //销毁当前activity
                finish()
            }
        })
    }


    //region点击事件
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fourth_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> longMessage("you click add_item")
            R.id.remove_item -> {
                longMessage("you click remove_item")

                //此方法用于传输数据给调用方activity
                setResult(RESULT_OK, getReturnIntent())

                //销毁当前activity
                finish()
            }
        }
        return true
    }
    //endregion


    //要返回的数据
    private fun getReturnIntent(): Intent {
        //设置activity结束时返回给调用activity的数据
        val intent = Intent()
        //各种重载
        intent.putExtra("ext1", 12)
        intent.putExtra("ext2", "String")
        intent.putExtra("ext3", arrayOf(1, 2))
        return intent
    }
}