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

/**
 * 两种方式加载自定义的布局。  推荐 2
 * 1：主布局中 <include layout="@layout/title_layout"/> 表示引入这个布局， 此时被引入布局的事件需要自行实现
 * 2：主布局中 <com.example.customlayout.TitleLayout android:layout_width="match_parent" android:layout_height="wrap_content"/> 表示引入此控件， 此控件已对被引入布局做了默认事件，无需重复实现。
 * com.example.customlayout.TitleLayout表示自定义控件的位置， 包名不可省略
 */