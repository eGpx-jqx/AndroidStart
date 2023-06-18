package com.example.customlayout

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

/**
 * 自定义的控件， 虽然可以在布局文件中引入title布局，但是头布局buttle的点击实现需要每次都重写。  可使用自定义控件解决此问题。
 */
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        /**
         * 将title_layout布局加载到当前布局。
         * R.layout.title_layout： 要加载的布局
         * this： 被加载布局添加一个父布局
         */
        val layoutInflater = LayoutInflater.from(context)
        layoutInflater.inflate(R.layout.title_layout, this)


        //title布局点击事件
        findViewById<Button>(R.id.titleBack).setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        findViewById<Button>(R.id.titleEdit).setOnClickListener {
            Toast.makeText(context, "you clicked edit button", Toast.LENGTH_LONG).show()
        }
    }
}