package com.mustang4w.wang.kotlinpractiseproject.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.mustang4w.wang.kotlinpractiseproject.R
import kotlinx.android.synthetic.main.activity_chat.*
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

class ChatActivity : BaseActivity(), View.OnClickListener {

    lateinit var client: WebSocketClient

    companion object {
        @JvmStatic
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, ChatActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        btnConnect.setOnClickListener(this)

        initWebSocketClient()
    }

    private fun initWebSocketClient() {
        client = object : WebSocketClient(URI("ws://196.168.66.93:8081/chat/")) {
            override fun onOpen(p0: ServerHandshake?) {
                txtStatus.text = edtName.text.append("，已连接")
            }

            override fun onClose(p0: Int, p1: String?, p2: Boolean) {
                Log.d("TAG", p1.toString())
            }

            override fun onMessage(p0: String?) {
                Log.d("TAG", p0.toString())
            }

            override fun onError(p0: Exception?) {
                Log.d("TAG", p0?.message.toString())
            }
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == btnConnect.id) {
            connect()
        }
    }

    private fun connect() {
        client.connect()
    }

}
