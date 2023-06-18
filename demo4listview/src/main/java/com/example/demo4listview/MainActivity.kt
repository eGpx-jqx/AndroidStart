package com.example.demo4listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demo4listview.databinding.ActivityMainBinding
import com.example.demo4listview.entity.Fruit
import com.example.demo4listview.listadapter.FruitAdapter

/**
 * listView已被更强大的RecyclerView取代！
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //要展示在列表中的数据实体
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MainActivity", "getView: $this")
        initFruit()
        //配置列表listView的adapter
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        //设置列表的适配器（动态装配列表数据，获取每一列的视图对象）
        binding.listView.adapter = adapter

        //设置列表的点击事件
        /**
         * parent: 指listView 视图对象， 内含n个列表视图对象
         * view： 指fruit_item视图对象，包含在listView中
         * position：此view在adapter中的位置
         * id：此列表第几行
         */
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, "fruit is ${fruit.name}", Toast.LENGTH_LONG).show()
            Log.d("listView", "listView: $this")
            Log.d("listView", "listView: $parent")
            Log.d("listView", "listView: $view")
            Log.d("listView", "listView: $position")
            Log.d("listView", "listView: $id")
        }
    }


    private fun initFruit() {
        repeat(5) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }


}