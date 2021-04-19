package com.mustang4w.wang.kotlinpractiseproject.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mustang4w.wang.kotlinpractiseproject.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnToSecond.setOnClickListener {
            SecondActivity.actionStart(this, "aaa", "bbb")
        }
        btnToChat.setOnClickListener {
            ChatActivity.actionStart(this)
        }
        btnToListView.setOnClickListener {
            ListViewActivity.actionStart(this)
        }
        btnToRecyclerView.setOnClickListener {
            RecyclerViewActivity.actionStart(this)
        }
        btnTo9Patch.setOnClickListener {
            UI9PatchActivity.actionStart(this)
        }
        btnToFragment.setOnClickListener {
            FragmentActivity.actionStart(this)
        }
        btnSendBroadcast.setOnClickListener {
            val intent = Intent("com.mustang4w.wang.kotlinpractiseproject.broadcast.MY_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }
        btnSendOrderBroadcast.setOnClickListener {
            val intent = Intent("com.mustang4w.wang.kotlinpractiseproject.broadcast.MY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
        }

        initBroadcastReceiver()
    }

    private lateinit var timeChangeReceiver: TimeChangeReceiver

    /**
     * 完整的系统广播列表
     *
     * <Android SDK>/platforms/<any Android api version>/data/broadcast_action.txt
     */
    private fun initBroadcastReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //getMenuInflater()
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addItem -> Toast.makeText(this, "Add Clicked..", Toast.LENGTH_SHORT).show()
            R.id.removeItem -> Toast.makeText(this, "Remove Clicked..", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }

    }
}
