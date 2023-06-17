package com.example.demoandroidlifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.demoandroidlifecycle.databinding.ActivityMainBinding

/**
 * active生命周期
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //创建此activity时调用， 初始化工作， 一般只调用一次，后续如果被onDestroy了则会再次onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //用于获取上次此activity被销毁时保存的数据
        val string = savedInstanceState?.getString("ext1")

        binding.toNormal.setOnClickListener {
            Log.d("MainActivity", "onCreate: toNormal")
            startActivity(Intent(this, NormalActivity::class.java))
        }

        binding.toDialog.setOnClickListener {
            Log.d("MainActivity", "onCreate: toDialog")
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    //此activity可见时调用
    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    //此activity准备好和用户交互时调用， 此时activity一定处于栈顶
    override fun onResume() {
        Log.d("MainActivity", "onResume")
        super.onResume()
    }

    //此activity停止 但是依旧可见  如调用dialog时
    override fun onPause() {
        Log.d("MainActivity", "onPause")
        super.onPause()
    }

    //此activity停止 完全不可见
    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    //此activity被销毁
    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }

    //重新启动， 如转到toNormal后，按下返回键， 此时调用此方法替代onCreat（如果此activity已被销毁，则是onCreate）， 然后onStart，onResume。
    override fun onRestart() {
        Log.d("MainActivity", "onRestart")
        super.onRestart()
    }


    /**
     * 当activity不可见时， 安卓虚拟机可能会回收此activity，此时此方法会运行， 一般此方法内用于保存上次activity的数据
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ext1","the data left by mainActivity")
    }
}