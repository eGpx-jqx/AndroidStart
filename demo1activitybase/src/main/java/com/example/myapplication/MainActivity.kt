package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ext.longMessage


class MainActivity : AppCompatActivity() {

    //见: https://juejin.cn/post/6921677731088646158   创建binding类绑定layout和activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toSecond.setOnClickListener(secondOnclick)
        binding.toThree.setOnClickListener(threeOnClick)

        //下一个activity结束后有返回值的跳转
        //StartActivityForResult参数是一个google提供的合约，表示用于获取activity的结果
        /**
         * 合约都在 ActivityResultContracts中， 可自定义合约 继承ActivityResultContracts即可
         * RequestMultiplePermissions： 用于请求一组权限
         * RequestPermission: 用于请求单个权限
         * TakePicturePreview: 调用MediaStore.ACTION_IMAGE_CAPTURE拍照，返回值为Bitmap图片
         * TakePicture: 调用MediaStore.ACTION_IMAGE_CAPTURE拍照，并将图片保存到给定的Uri地址，返回true表示保存成功。
         * TakeVideo: 调用MediaStore.ACTION_VIDEO_CAPTURE 拍摄视频，保存到给定的Uri地址，返回一张缩略图。
         * PickContact: 从通讯录APP获取联系人
         * GetContent: 提示用选择一条内容，返回一个通过ContentResolver#openInputStream(Uri)访问原生数据的Uri地址（content://形式） 。默认情况下，它增加了 Intent#CATEGORY_OPENABLE, 返回可以表示流的内容。
         * CreateDocument: 提示用户选择一个文档，返回一个(file:/http:/content:)开头的Uri。
         * OpenMultipleDocuments: 提示用户选择文档（可以选择多个），分别返回它们的Uri，以List的形式。
         * OpenDocumentTree: 提示用户选择一个目录，并返回用户选择的作为一个Uri返回，应用程序可以完全管理返回目录中的文档。
         * 上面这些预定义的Contract中，除了StartActivityForResult和RequestMultiplePermissions之外，基本都是处理的与其他APP交互，返回数据的场景，比如，拍照，选择图片，选择联系人，打开文档等等。使用最多的就是StartActivityForResult和RequestMultiplePermissions了。
         */
        val launcher = registerForActivityResult(StartActivityForResult()) { rs ->
            Log.d("MainActivity", "rs: $rs")
            Log.d("MainActivity", "rsCode: ${rs.resultCode}")
            Log.d("MainActivity", "rsData: ${rs.data?.getStringExtra("ext1")}")
        }
        binding.toFourth.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("ext1", "hello fourth")
            }
            //由以上注册的ActivityResultLauncher发起调用
            launcher.launch(intent)
        }
    }


    //meun相关， 填充menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //menu菜单选择触发事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> longMessage("you click add_item")
            R.id.remove_item -> longMessage("you click remove_item")
        }
        return true
    }


    //region  onClick点击事件相关方法   intent
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

    //endregion
}