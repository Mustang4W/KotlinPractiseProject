package com.mustang4w.wang.kotlinpractiseproject.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustang4w.wang.kotlinpractiseproject.R
import com.mustang4w.wang.kotlinpractiseproject.adapter.UI9PatchAdapter
import com.mustang4w.wang.kotlinpractiseproject.entity.ChatMessageEntity
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.activity_ui_9_patch.*
import kotlinx.android.synthetic.main.activity_ui_9_patch.recyclerChat

class UI9PatchActivity : BaseActivity(), View.OnClickListener {

    private val messageList = ArrayList<ChatMessageEntity>()
    private lateinit var adapter: UI9PatchAdapter

    companion object {
        @JvmStatic
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, UI9PatchActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_9_patch)

        initMessage()

        if (!::adapter.isInitialized) {
            adapter = UI9PatchAdapter(messageList)
        }
        recyclerChat.layoutManager = LinearLayoutManager(this)
        recyclerChat.adapter = adapter

        btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnSend -> {
                val content = edtInput.text.toString()
                if (content.isNotEmpty()) {
                    val msg = ChatMessageEntity(content, ChatMessageEntity.TYPE_SEND)
                    messageList.add(msg)
                    adapter.notifyItemInserted(messageList.size - 1)
                    recyclerChat.scrollToPosition(messageList.size - 1)
                    edtInput.setText("")
                }
            }
        }
    }

    private fun initMessage() {
        val msg1 = ChatMessageEntity("Hello guy.", ChatMessageEntity.TYPE_RECEIVED)
        messageList.add(msg1)
        val msg2 = ChatMessageEntity("Hello. Who is that?", ChatMessageEntity.TYPE_SEND)
        messageList.add(msg2)
        val msg3 = ChatMessageEntity("This is Tom. Nice talking to you. ", ChatMessageEntity.TYPE_RECEIVED)
        messageList.add(msg3)
    }
}
