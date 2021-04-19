package com.mustang4w.wang.kotlinpractiseproject.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.mustang4w.wang.kotlinpractiseproject.R
import com.mustang4w.wang.kotlinpractiseproject.fragment.LeftFragment
import com.mustang4w.wang.kotlinpractiseproject.fragment.RightFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : BaseActivity() {

    companion object {
        @JvmStatic
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, FragmentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

//        initFragment()

        //根据布局id直接获取Fragment实例
        val leftFragment = leftFragment as LeftFragment
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightFragment, RightFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
