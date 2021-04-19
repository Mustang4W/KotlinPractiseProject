package com.mustang4w.wang.kotlinpractiseproject.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.mustang4w.wang.kotlinpractiseproject.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {

    /**
     * companion object内并不是真正的静态方法，kotlin内部会默认创建一个伴生实例
     *
     * 如果需要用java调用真正的静态方法需要在方法前加注解@JvmStatic
     */
    companion object {
        @JvmStatic
        fun actionStart(context: Context, param1: String, param2: String) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("param1", param1)
                putExtra("param2", param2)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val param1 = intent.getStringExtra("param1") ?: ""
        val param2 = intent.getStringExtra("param2") ?: ""
        Log.d("SecondActivity", param1)
        Log.d("SecondActivity", param2)

        btnToFirst.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Title")
                setMessage("This is a Dialog")
            }.show()
        }
    }
}
