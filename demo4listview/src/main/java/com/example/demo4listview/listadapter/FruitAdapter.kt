package com.example.demo4listview.listadapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.demo4listview.R
import com.example.demo4listview.entity.Fruit

/**
 * 自定义FruitAdapter
 */
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    inner class ViewHolder(val fruitImage: ImageView, val textView: TextView)

    /**
     * 列表每展示一列对象就会调用一次此方法，获取一个view来展示
     * context： 这里的上下文 就是主MainActivity对象
     * resourceId： 是fruit_item.xml的id，
     * position： 列表中第几列数据，下标
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //获取activity_main的布局填充器， 填充fruit_item到主布局的listView中。   parent（ListView）
        //convertView是缓存的之前加载好的布局， 有的话就直接用了, 资源节省
        //实际第一次启动主activity展示list的时候，第一页的列表 会多线程并发同时获取到每个view， 此时用不到缓存。
        val view = convertView ?: LayoutInflater.from(context).inflate(resourceId, parent, false)


        var fruitView: ImageView
        var fruitText: TextView

        //fruitImage和fruitText之前找过，直接用，否则再次查询并缓存
        view.tag.apply {
            if (this != null) {
                val viewHolder = this as ViewHolder
                fruitView = viewHolder.fruitImage
                fruitText = viewHolder.textView
                Log.d("viewHolder", "viewHolder: YES")
            } else {
                Log.d("viewHolder", "viewHolder: NO")
                fruitView = view.findViewById(R.id.fruitImage)
                fruitText = view.findViewById(R.id.fruitText)

                //将fruitView和fruitText缓存起来， 这样不用每次去找此资源， 性能优化
                view.tag = ViewHolder(fruitView, fruitText)
            }
        }
        //设置此view的数据
        val fruit = getItem(position)
        if (fruit != null) {
            fruitView.setImageResource(fruit.imageId)
            fruitText.text = fruit.name
        }
        return view
    }
}